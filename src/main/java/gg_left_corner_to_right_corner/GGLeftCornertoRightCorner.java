package gg_left_corner_to_right_corner;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class GGLeftCornertoRightCorner {
    // 给定一个矩形的长宽，用多少种方法可以从左上角走到右上角 （每一步，只能向正右、右上 或 右下走）：整个矩形遍历做DP即可，不需要想复杂
    // Insert your Solution class here
    class Solution {
        public int calcWays(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

            int m = grid.length;
            int n = grid[0].length;

            int[][] dp = new int[m][n];
            dp[0][0] = 1;
            for (int i=1; i<n; i++) {
                dp[0][i] = 1;
                for (int j=1; j<m; j++) {
                    dp[j][i] = dp[j][i-1];
                    if (j > 1)
                        dp[j][i] += dp[j-1][i-1];
                    if (j < m-1)
                        dp[j][i] += dp[j+1][i-1];
                }
            }
            return dp[0][n-1];
        }
    }

    public static class UnitTest {
        @Test
        public void testGGLeftCornertoRightCorner() {
            Solution s = new GGLeftCornertoRightCorner().new Solution();
        }
    }
}

