package toeplitz_matrix;

import org.junit.Test;

public class ToeplitzMatrix {

    // Insert your Solution class here
    class Solution {
        public boolean isToeplitzMatrix(int[][] matrix) {
            int row = matrix.length;
            if (row == 1) return true;
            int col = matrix[0].length;
            if (col == 1) return true;

            for (int i=0; i<col; i++) {
                int val = matrix[0][i];
                for (int j=1; j<row && i+j<col; j++) {
                    if (val != matrix[j][i+j]) return false;
                }
            }
            for (int i=1; i<row; i++) {
                int val = matrix[i][0];
                for (int j=1; j<col && i+j<row; j++) {
                    if (val != matrix[i+j][j]) return false;
                }
            }

            return true;
        }
    }

    // very simple solution
    class Solution1 {
        public boolean isToeplitzMatrix(int[][] matrix) {
            int row = matrix.length;
            if (row == 1) return true;
            int col = matrix[0].length;
            if (col == 1) return true;

            for (int i=0; i<col-1; i++) {
                for (int j=0; j<row-1; j++) {
                    if (matrix[i][j] != matrix[i+1][j+1]) return false;
                }
            }
            return true;
        }
    }

    public static class UnitTest {
        @Test
        public void testToeplitzMatrix() {
            Solution s = new ToeplitzMatrix().new Solution();
        }
    }
}

