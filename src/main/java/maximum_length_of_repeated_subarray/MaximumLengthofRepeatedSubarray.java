package maximum_length_of_repeated_subarray;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MaximumLengthofRepeatedSubarray {
//    Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
//
//            Example 1:
//    Input:
//    A: [1,2,3,2,1]
//    B: [3,2,1,4,7]
//    Output: 3
//    Explanation:
//    The repeated subarray with maximum length is [3, 2, 1].
//    Note:
//            1 <= len(A), len(B) <= 1000
//            0 <= A[i], B[i] < 100

    // Insert your Solution class here
    class Solution {
        public int findLength(int[] A, int[] B) {
            int[][] dp = new int[A.length+1][B.length+1];
            int res = 0;
            for (int i=0; i<A.length; i++) {
                for (int j=0; j<B.length; j++) {
                    if (A[i] == B[j]) {
                        dp[i+1][j+1] = dp[i][j] + 1;
                        res = Math.max(res, dp[i+1][j+1]);
                    }
                }
            }
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testMaximumLengthofRepeatedSubarray() {
            Solution s = new MaximumLengthofRepeatedSubarray().new Solution();
        }
    }
}

