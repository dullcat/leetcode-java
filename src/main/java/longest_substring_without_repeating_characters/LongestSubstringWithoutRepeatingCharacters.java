package longest_substring_without_repeating_characters;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    // Insert your Solution class here
    public class Solution {
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

