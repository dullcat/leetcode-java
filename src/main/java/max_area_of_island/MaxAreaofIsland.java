package max_area_of_island;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MaxAreaofIsland {

    // Insert your Solution class here
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int max = 0;
            for (int i=0; i<grid.length; i++) {
                for (int j=0; j<grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        max = Math.max(max, dfs(grid, i, j));
                    }
                }
            }
            return max;
        }

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int dfs(int[][] grid, int x, int y) {
            if (x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]==0) return 0;
            grid[x][y] = 0;
            int sum = 1;
            for (int i=0; i<4;i++) {
                sum += dfs(grid, x+directions[i][0], y+directions[i][1]);
            }
            return sum;
        }
    }

    public static class UnitTest {
        @Test
        public void testMaxAreaofIsland() {
            Solution s = new MaxAreaofIsland().new Solution();
        }
    }
}

