package range_sum_query_2d_immutable;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class RangeSumQuery2DImmutable {
//    Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
//
//    Range Sum Query 2D
//    The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
//
//    Example:
//    Given matrix = [
//            [3, 0, 1, 4, 2],
//            [5, 6, 3, 2, 1],
//            [1, 2, 0, 1, 5],
//            [4, 1, 0, 1, 7],
//            [1, 0, 3, 0, 5]
//            ]
//
//    sumRegion(2, 1, 4, 3) -> 8
//    sumRegion(1, 1, 2, 2) -> 11
//    sumRegion(1, 2, 2, 4) -> 12
//    Note:
//    You may assume that the matrix does not change.
//    There are many calls to sumRegion function.
//    You may assume that row1 ≤ row2 and col1 ≤ col2.

    // Insert your Solution class here
    class NumMatrix {
        int[][] sums;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
            sums = new int[matrix.length][matrix[0].length];

            int[] row = new int[matrix[0].length];
            row[0] = sums[0][0] = matrix[0][0];
            for (int j=1; j<matrix[0].length; j++) {
                row[j] = matrix[0][j];
                sums[0][j] = sums[0][j-1] + row[j];
            }

            for (int i=1; i<matrix.length; i++) {
                row[0] = row[0] + matrix[i][0];
                sums[i][0] = row[0];
                for (int j=1; j<matrix[0].length; j++) {
                    row[j] = row[j] + matrix[i][j];
                    sums[i][j] = sums[i][j-1] + row[j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (row1 == 0 && col1 == 0) return sums[row2][col2];
            if (row1 == 0) return sums[row2][col2] - sums[row2][col1-1];
            if (col1 == 0) return sums[row2][col2] - sums[row1-1][col2];
            return sums[row2][col2] - sums[row1-1][col2] - sums[row2][col1-1] + sums[row1-1][col1-1];
        }
    }

    /**
     * Your NumMatrix object will be instantiated and called as such:
     * NumMatrix obj = new NumMatrix(matrix);
     * int param_1 = obj.sumRegion(row1,col1,row2,col2);
     */
    public static class UnitTest {
        @Test
        public void testRangeSumQuery2DImmutable() {
            //Solution s = new RangeSumQuery2DImmutable().new Solution();
        }
    }
}

