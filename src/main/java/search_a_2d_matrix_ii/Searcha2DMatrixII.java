package search_a_2d_matrix_ii;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class Searcha2DMatrixII {
//    Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
//    Integers in each row are sorted in ascending from left to right.
//    Integers in each column are sorted in ascending from top to bottom.
//    Example:
//
//    Consider the following matrix:
//
//            [
//            [1,   4,  7, 11, 15],
//            [2,   5,  8, 12, 19],
//            [3,   6,  9, 16, 22],
//            [10, 13, 14, 17, 24],
//            [18, 21, 23, 26, 30]
//            ]
//    Given target = 5, return true.
//
//    Given target = 20, return false.
//

    // Insert your Solution class here
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

            int m = matrix.length;
            int n = matrix[0].length;
            for (int i=0; i<m; i++) {
                if (matrix[i][0] > target || matrix[i][n-1] < target) continue;
                int left = 0;
                int right = n-1;
                while (left <= right) {
                    int mid = left + (right-left) / 2;
                    if (matrix[i][mid] == target) return true;
                    else if (matrix[i][mid] < target) {
                        left = mid + 1;
                    }
                    else {
                        right = mid - 1;
                    }
                }
            }
            return false;
        }
    }
    public static class UnitTest {
        @Test
        public void testSearcha2DMatrixII() {
            Solution s = new Searcha2DMatrixII().new Solution();
        }
    }
}

