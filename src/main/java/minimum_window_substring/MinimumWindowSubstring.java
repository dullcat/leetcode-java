package minimum_window_substring;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MinimumWindowSubstring {
//    Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
//
//    Example:
//
//    Input: S = "ADOBECODEBANC", T = "ABC"
//    Output: "BANC"
//    Note:
//
//    If there is no such window in S that covers all characters in T, return the empty string "".
//    If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

    // Insert your Solution class here
    class Solution {
        public String minWindow(String s, String t) {
            if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";

            Map<Character, Integer> map = new HashMap<>();
            for (char c: t.toCharArray()) {
                if (!map.containsKey(c)) {
                    map.put(c, 1);
                }
                else
                    map.put(c, map.get(c) + 1);
            }

            int minLeft = 0;
            int minLen = Integer.MAX_VALUE;
            int count = t.length();
            int base = 0;
            for (int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c)-1);
                    if (map.get(c) >= 0)
                        count--;
                }
                while (count == 0) {
                    if (i-base<minLen) {
                        minLeft = base;
                        minLen = i-base+1;
                    }
                    char b = s.charAt(base);
                    if (map.containsKey(b)) {
                        map.put(b, map.get(b)+1);
                        if (map.get(b) > 0)
                            count++;
                    }
                    base++;
                }
            }

            return minLen==Integer.MAX_VALUE? "" : s.substring(minLeft, minLeft+minLen);
        }
    }

    class Solution2 {

        private boolean cover(Map<Character, Integer> m1, Map<Character, Integer> m2) {
            for (char c: m2.keySet()) {
                if (!m1.containsKey(c) || m1.get(c)<m2.get(c)) return false;
            }
            return true;
        }
        public String minWindow(String s, String t) {
            if (s == null || t== null || s.equals("") || t.equals("")) return "";
            HashMap<Character, Integer> mapt = new HashMap();
            for (char c : t.toCharArray()) {
                mapt.put(c, mapt.getOrDefault(c, 0) + 1);
            }

            HashMap<Character, Integer> map = new HashMap<>();
            int minS = -1;
            int minE = -1;
            int left = 0;
            int right = 0;
            while (right < s.length()) {
                while (right < s.length() && !cover(map, mapt)) {
                    if (mapt.containsKey(s.charAt(right))) {
                        map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
                    }
                    right++;
                }


                while (cover(map, mapt)) {
                    if (minE < 0 || right-left < minE-minS) {
                        minS = left;
                        minE = right;
                    }
                    if (mapt.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                    }
                    left++;
                }
                //if (minE-minS == map.size()) break; // already found min window
            }
            if (minE <= 0 || minS < 0) return "";
            return s.substring(minS, minE);
        }
    }
    class Solution1 {
        public String minWindow(String s, String t) {
            if (s == null || t== null || s.equals("") || t.equals("")) return "";
            HashSet<Character> set = new HashSet();
            for (char c : t.toCharArray()) {
                set.add(c);
            }

            HashMap<Character, Integer> map = new HashMap<>();
            int minS = -1;
            int minE = -1;
            int left = 0;
            int right = 0;
            while (right < s.length()) {
                while (right < s.length() && map.size() < set.size()) {
                    if (set.contains(s.charAt(right))) {
                        map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
                    }
                    right++;
                }
                //if (map.size() < set.size()) break;
                minE = right;

                while (map.size() == set.size()) {
                    if (set.contains(s.charAt(left))) {
                        int n = map.get(s.charAt(left));
                        if (n > 1) {
                            map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                        }
                        else {
                            map.remove(s.charAt(left));
                        }
                    }
                    minS = left++;
                }
                if (minE-minS == set.size()) break; // already found min window
            }
            if (minE <= 0 || minS < 0) return "";
            return s.substring(minS, minE);
        }
    }
    public static class UnitTest {
        @Test
        public void testMinimumWindowSubstring() {
            Solution s = new MinimumWindowSubstring().new Solution();
            assertEquals(s.minWindow("ADOBECODEBANC", "ABC"), "BANC");
            assertEquals(s.minWindow("a", "aa"), "");
            assertEquals(s.minWindow("abcdab", "aab"), "abcda");
            assertEquals(s.minWindow("cabwefgewcwaefgcf", "cae"), "cwae");
        }
    }
}

