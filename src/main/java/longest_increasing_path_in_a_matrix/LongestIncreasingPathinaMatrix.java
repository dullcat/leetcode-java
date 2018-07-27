package longest_increasing_path_in_a_matrix;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class LongestIncreasingPathinaMatrix {
//    Given an integer matrix, find the length of the longest increasing path.
//
//    From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
//
//    Example 1:
//
//    Input: nums =
//            [
//            [9,9,4],
//            [6,6,8],
//            [2,1,1]
//            ]
//    Output: 4
//    Explanation: The longest increasing path is [1, 2, 6, 9].
//    Example 2:
//
//    Input: nums =
//            [
//            [3,4,5],
//            [3,2,6],
//            [2,2,1]
//            ]
//    Output: 4
//    Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

    // Insert your Solution class here
    class Solution {
        public int longestIncreasingPath(int[][] matrix) {
            if (matrix.length==0 || matrix[0].length==0) return 0;
            int row = matrix.length;
            int col = matrix[0].length;
            int[][] memo = new int[row][col];
            int res = 0;
            for (int i=0; i<row; i++) {
                for (int j=0; j<col; j++) {
                    res = Math.max(res, dfs(matrix, memo, i, j));
                }
            }
            return res;
        }

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        private int dfs(int[][] matrix, int[][] memo, int r, int c) {
            if (r<0 || r>=matrix.length || c<0 || c>=matrix[0].length) return 0;
            if (memo[r][c] > 0) return memo[r][c];
            int res = 1;
            for (int i=0; i<4; i++) {
                int newR = r+dirs[i][0];
                int newC = c+dirs[i][1];
                if (newR>=0 && newR<matrix.length && newC>=0 && newC<matrix[0].length && matrix[r][c] < matrix[newR][newC])
                    res = Math.max(res, 1+dfs(matrix, memo, r+dirs[i][0], c+dirs[i][1]));
            }
            memo[r][c] = res;
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testLongestIncreasingPathinaMatrix() {
            Solution s = new LongestIncreasingPathinaMatrix().new Solution();
        }
    }
}

