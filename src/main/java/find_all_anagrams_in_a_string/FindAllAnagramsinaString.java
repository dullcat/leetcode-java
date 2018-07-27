package find_all_anagrams_in_a_string;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class FindAllAnagramsinaString {
//    Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
//
//    Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
//
//    The order of output does not matter.
//
//    Example 1:
//
//    Input:
//    s: "cbaebabacd" p: "abc"
//
//    Output:
//            [0, 6]
//
//    Explanation:
//    The substring with start index = 0 is "cba", which is an anagram of "abc".
//    The substring with start index = 6 is "bac", which is an anagram of "abc".
//
//    Example 2:
//
//    Input:
//    s: "abab" p: "ab"
//
//    Output:
//            [0, 1, 2]
//
//    Explanation:
//    The substring with start index = 0 is "ab", which is an anagram of "ab".
//    The substring with start index = 1 is "ba", which is an anagram of "ab".
//    The substring with start index = 2 is "ab", which is an anagram of "ab".

    // Insert your Solution class here
    // Fastest. 6ms.
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {

            char[] ptrn = p.toCharArray();
            char[] str = s.toCharArray();

            int[] w = new int[26];

            for(char c : ptrn) w[c - 'a']++;

            int start = 0;

            List<Integer> result = new LinkedList<>();

            for(int i = 0; i<str.length; i++){
                int cIndex = str[i] - 'a';

                w[cIndex]--;
                // the crucial bit, if we have seen the character too many times
                // or it is a character that is not in the pattern, rewind the starting index
                while(w[cIndex] < 0){
                    w[str[start] - 'a']++;
                    start++;
                }

                if(i - start + 1 == ptrn.length){
                    result.add(start);
                    w[str[start] - 'a']++;
                    start++;
                }
            }


            return result;
        }
    }
    // Better. 19ms.
    class Solution2 {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            if (s == null || p == null) return res;

            Set<Character> set = new HashSet<>();
            int[] map = new int[26];
            int count = 0;
            for (char c: p.toCharArray()) {
                set.add(c);
                map[c-'a']++;
            }
            int left = 0;
            int right = 0;
            while (right < s.length()) {
                char c = s.charAt(right);
                if (set.contains(c)) {
                    map[c-'a']--;
                    if (map[c-'a'] >= 0) {
                        count++;
                    }
                }
                while (count == p.length()) {
                    if (right-left+1 == p.length()) {
                        res.add(left);
                    }
                    char cLeft = s.charAt(left);
                    if (set.contains(cLeft)) {
                        map[cLeft-'a']++;
                        if (map[cLeft-'a'] > 0)
                            count--;
                    }
                    left++;
                }
                right++;
            }

            return res;
        }
    }
    // Time is long. 1000+ms
    class Solution1 {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            if (s == null || p == null) return res;

            Set<Character> set = new HashSet<>();
            int[] map = new int[26];
            int count = 0;
            for (char c: p.toCharArray()) {
                set.add(c);
                map[c-'a']++;
                count++;
            }
            for (int i=0; i<s.length(); i++) {
                while (i<s.length() && !set.contains(s.charAt(i))) i++;

                int[] curMap = map.clone();
                int curCount = count;
                int j = i;
                while (j<s.length() && set.contains(s.charAt(j)) && curMap[s.charAt(j)-'a'] > 0) {
                    curMap[s.charAt(j)-'a']--;
                    curCount--;
                    j++;
                }
                if (curCount == 0)
                    res.add(i);
                if (j<s.length() && j > i && !set.contains(s.charAt(j)))
                    i = j;
            }

            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testFindAllAnagramsinaString() {
            Solution s = new FindAllAnagramsinaString().new Solution();
        }
    }
}

