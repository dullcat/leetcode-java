package flip_string_to_monotone_increasing;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class FlipStringtoMonotoneIncreasing {
//    A string of '0's and '1's is monotone increasing if it consists of some number of '0's (possibly 0), followed by some number of '1's (also possibly 0.)
//
//    We are given a string S of '0's and '1's, and we may flip any '0' to a '1' or a '1' to a '0'.
//
//    Return the minimum number of flips to make S monotone increasing.
//
//
//
//            Example 1:
//
//    Input: "00110"
//    Output: 1
//    Explanation: We flip the last digit to get 00111.
//    Example 2:
//
//    Input: "010110"
//    Output: 2
//    Explanation: We flip to get 011111, or alternatively 000111.
//    Example 3:
//
//    Input: "00011000"
//    Output: 2
//    Explanation: We flip to get 00000000.
//
//
//    Note:
//
//            1 <= S.length <= 20000
//    S only consists of '0' and '1' characters.

    // Insert your Solution class here
    class Solution {
        public int minFlipsMonoIncr(String S) {
            if (S == null || S.length() < 2) return 0;
            int n = S.length();
            int[] leftOnes = new int[n+1];
            int[] rightZeros = new int[n+1];

            for (int i=1; i<=n; i++) {
                leftOnes[i] = leftOnes[i-1] + (S.charAt(i-1) =='1'? 1 : 0);
                System.out.println(leftOnes[i]);
            }
            for (int i=n-1; i>=0; i--) {
                rightZeros[i] = rightZeros[i+1] + (S.charAt(i) == '0' ? 1 : 0);
            }

            int res = 20000;
            for (int i=0; i<=n; i++) {
                res = Math.min(res, leftOnes[i]+rightZeros[i]);
            }
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testFlipStringtoMonotoneIncreasing() {
            Solution s = new FlipStringtoMonotoneIncreasing().new Solution();
            assertEquals(s.minFlipsMonoIncr("0010110"), 2);
            assertEquals(s.minFlipsMonoIncr("0000110"), 1);
        }
    }
}

