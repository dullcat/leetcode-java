package shortest_palindrome;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ShortestPalindrome {


    // Insert your Solution class here
    public class Solution {
        // short recursive solution. see: https://discuss.leetcode.com/topic/21068/my-7-lines-recursive-java-solution
        public String shortestPalindrome1(String s) {
            int end = s.length() - 1;
            int j = 0;
            while (j <= end) {
                end = j == 0 ? end: j - 1;
                j = 0;
                for (int i = end; i >= 0; i--)
                    if (s.charAt(i) == s.charAt(j)) j++;
            }
            return new StringBuilder(s.substring(j)).reverse().toString() + s;
        }

        public String shortestPalindrome(String s) {
            if (s == null) return "";
            int n = s.length();
            if (n <= 1) return s;

            for (int i=(2*n-1)/2; i>=0; i--) {
                int missingPoint = findFarRightMissingLeft(s, i);
                if (missingPoint == -2) return s;
                if (missingPoint != -1) {
                    String res = mirrorRight(s, i);
                    return res;
                }
            }
            return null;
        }
        int findFarRightMissingLeft(String s, int mid) {
            int left = mid/2, right = mid/2 + mid%2;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--; right++;
            }
            if (left >= 0) return -1; // no palindrome for this middle point
            if (right == s.length()) return -2; // already palindrome
            return right;
        }

        String mirrorRight(String s, int mid) {
            StringBuilder res = new StringBuilder();
            int start = mid/2 + 1;
            for (int i = s.length()-1; i >= start; i--) {
                res.append(s.charAt(i));
            }
            res.append(s.substring(mid/2 + mid%2));
            return res.toString();
        }
    }
    public static class UnitTest {
        @Test
        public void testShortestPalindrome() {
            Solution s = new ShortestPalindrome().new Solution();
            assertEquals("aaacecaaa", s.shortestPalindrome("aacecaaa"));
            assertEquals("abbaabba", s.shortestPalindrome("aabba"));
            assertEquals("dcbabcd", s.shortestPalindrome("abcd"));
            assertEquals("adbeccbabccebda", s.shortestPalindrome("abccebda"));
        }
    }
}

