package surface_area_of_3d_shapes;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class SurfaceAreaof3DShapes {
//    On a N * N grid, we place some 1 * 1 * 1 cubes.
//
//    Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
//
//    Return the total surface area of the resulting shapes.
//
//
//
//    Example 1:
//
//    Input: [[2]]
//    Output: 10
//    Example 2:
//
//    Input: [[1,2],[3,4]]
//    Output: 34
//    Example 3:
//
//    Input: [[1,0],[0,2]]
//    Output: 16
//    Example 4:
//
//    Input: [[1,1,1],[1,0,1],[1,1,1]]
//    Output: 32
//    Example 5:
//
//    Input: [[2,2,2],[2,1,2],[2,2,2]]
//    Output: 46
//
//
//    Note:
//
//            1 <= N <= 50
//            0 <= grid[i][j] <= 50

    // Insert your Solution class here
    class Solution {
        public int surfaceArea(int[][] grid) {
            int N = grid.length;
            int res = 0;
            int h = 0;
            int shared = 0;
            int zeros = 0;
            for (int i = 0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (i > 0) {
                        shared += Math.min(grid[i-1][j], grid[i][j]);
                    }
                    if (j > 0)
                        shared += Math.min(grid[i][j-1], grid[i][j]);
                    h += grid[i][j];
                    if (grid[i][j] == 0) zeros++;
                }
            }
            res = (N * N - zeros) * 2 + h * 4 - shared * 2;
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testSurfaceAreaof3DShapes() {
            Solution s = new SurfaceAreaof3DShapes().new Solution();
        }
    }
}

