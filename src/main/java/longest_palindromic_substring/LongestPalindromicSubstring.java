package longest_palindromic_substring;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class LongestPalindromicSubstring {

    // Insert your Solution class here
    public class Solution {
        int maxLen = 0;
        int maxLeft = 0, maxRight = 0;
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) return "";
            for (int i = 0; i< s.length(); i++) {
                findLongestPalindrome(s, i, false);
                findLongestPalindrome(s, i, true);
            }
            return s.substring(maxLeft, maxRight + 1);
        }

        private void findLongestPalindrome(String s, int start, boolean isEven) {
            int left = start, right = start + (isEven? 1: 0);
            while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--; right++;
            }
            left++;
            right--;
            if (right-left+1 > maxLen) {
                maxLeft = left;
                maxRight = right;
                maxLen = right-left + 1;
            }
        }
    }
    public static class UnitTest {
        @Test
        public void testLongestPalindromicSubstring() {
            Solution s = new LongestPalindromicSubstring().new Solution();
            assertEquals(s.longestPalindrome("cbbd"), "bb");
        }
    }
}

