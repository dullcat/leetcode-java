package longest_palindrome;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class LongestPalindrome {
//    Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
//
//    This is case sensitive, for example "Aa" is not considered a palindrome here.
//
//    Note:
//    Assume the length of given string will not exceed 1,010.
//
//    Example:
//
//    Input:
//            "abccccdd"
//
//    Output:
//            7
//
//    Explanation:
//    One longest palindrome that can be built is "dccaccd", whose length is 7.

    // Insert your Solution class here
    class Solution {
        public int longestPalindrome(String s) {
            int[] map = new int[256];
            for (char c: s.toCharArray()) {
                map[c]++;
            }
            int res = 0;
            boolean odd = false;
            for (int i: map) {
                if (i % 2 == 1) {
                    odd = true;
                    i--;
                }
                res += i;
            }
            if (odd) res++;
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testLongestPalindrome() {
            Solution s = new LongestPalindrome().new Solution();
        }
    }
}

