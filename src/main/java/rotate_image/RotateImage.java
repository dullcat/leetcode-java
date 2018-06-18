package rotate_image;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class RotateImage {

    // Insert your Solution class here
    class Solution {
        public void rotate(int[][] matrix) {
            int start = 0;
            int n = matrix.length;
            while (n > 1) {
                for (int i=0; i<n-1; i++) {
                    int t = matrix[start][start+i];
                    matrix[start][start+i] = matrix[start+n-1-i][start];
                    matrix[start+n-1-i][start] = matrix[start+n-1][start+n-1-i];
                    matrix[start+n-1][start+n-1-i] = matrix[start+i][start+n-1];
                    matrix[start+i][start+n-1] = t;
                }
                start++;
                n -= 2;
            }
        }
    }
    public static class UnitTest {
        @Test
        public void testRotateImage() {
            Solution s = new RotateImage().new Solution();
        }
    }
}

