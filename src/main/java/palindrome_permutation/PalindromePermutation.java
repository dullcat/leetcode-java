package palindrome_permutation;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class PalindromePermutation {
//    Given a string, determine if a permutation of the string could form a palindrome.
//
//            Example 1:
//
//    Input: "code"
//    Output: false
//    Example 2:
//
//    Input: "aab"
//    Output: true
//    Example 3:
//
//    Input: "carerac"
//    Output: true

    // Insert your Solution class here
    class Solution {
        public boolean canPermutePalindrome(String s) {
            int[] map = new int[256];
            for (char c: s.toCharArray()) {
                map[c]++;
            }
            int odd = 0;
            for (int i: map) {
                if ((i & 1) == 1) odd++;
            }
            return odd<=1;
        }
    }
    public static class UnitTest {
        @Test
        public void testPalindromePermutation() {
            Solution s = new PalindromePermutation().new Solution();
        }
    }
}

