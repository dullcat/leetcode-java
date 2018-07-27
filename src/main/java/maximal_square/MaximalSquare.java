package maximal_square;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MaximalSquare {
//    Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
//
//    Example:
//
//    Input:
//
//            1 0 1 0 0
//            1 0 1 1 1
//            1 1 1 1 1
//            1 0 0 1 0
//
//    Output: 4

    // Insert your Solution class here
    class Solution {
        public int maximalSquare(char[][] matrix) {
            if (matrix == null || matrix.length == 0) return 0;
            int rows = matrix.length;
            int cols = matrix[0].length;

            int max = 0;
            int[] heights = new int[cols];
            for (int i=0; i<rows; i++) {
                for (int j=0; j<cols; j++) {
                    if (matrix[i][j] == '0') heights[j] = 0;
                    else heights[j] = heights[j] + 1;
                }
                max = Math.max(max, findMaxSquare(heights));
                for (int k=0; k<cols; k++) {
                    System.out.println(heights[k]);
                }
            }

            return max;
        }

        private int findMaxSquare(int[] heights) {
            Stack<Integer> stack = new Stack();

            stack.push(-1);
            int res = 0;
            for (int i=0; i<=heights.length; i++) {
                int cur = i==heights.length? 0: heights[i];
                while (stack.peek()!=-1 && heights[stack.peek()] > cur) {
                    int popIdx = stack.pop();
                    int length = i - stack.peek() - 1;
                    int side = Math.min(length, heights[popIdx]);
                    res = Math.max(res, side * side);
                }
                stack.push(i);
            }
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testMaximalSquare() {
            Solution s = new MaximalSquare().new Solution();
            //int[] h = {4,0,0,3,0};
            //int[] h = {3,1,3,2,2};
            int[] h = {2,0,2,1,1};

            // [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
            int res = s.findMaxSquare(h);
            assertEquals(res, 1);

        }
    }
}

