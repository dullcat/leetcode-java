package longest_substring_without_repeating_characters;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
//    Given a string, find the length of the longest substring without repeating characters.
//
//    Example 1:
//
//    Input: "abcabcbb"
//    Output: 3
//    Explanation: The answer is "abc", which the length is 3.
//    Example 2:
//
//    Input: "bbbbb"
//    Output: 1
//    Explanation: The answer is "b", with the length of 1.
//    Example 3:
//
//    Input: "pwwkew"
//    Output: 3
//    Explanation: The answer is "wke", with the length of 3.
//    Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

    // Insert your Solution class here
    // char array
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.isEmpty()) return 0;
            int[] map = new int[256];
            int from = 0, to = 0;
            int max = 0;
            while (to < s.length()) {
                if (map[s.charAt(to)] == 0) {
                    map[s.charAt(to++)]++;
                    max = Math.max(max, to-from);
                }
                else {
                    map[s.charAt(from++)]--;
                }
            }
            return max;
        }
    }
    // Set
    public class Solution1 {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) return 0;
            int left = 0, right = 0, maxLen = 0;
            HashSet<Character> set = new HashSet<Character>();
            while (right < s.length()) {
                if (!set.contains(s.charAt(right))) {
                    set.add(s.charAt(right));
                    right++;
                    maxLen = Math.max(maxLen, right-left);
                }
                else {
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            return maxLen;
        }
    }
    public static class UnitTest {
        
    }
}

