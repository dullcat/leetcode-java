package number_of_islands;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class NumberofIslands {
//    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by
//    water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of
//    the grid are all surrounded by water.
//
//    Example 1:
//
//            11110
//            11010
//            11000
//            00000
//    Answer: 1
//
//    Example 2:
//
//            11000
//            11000
//            00100
//            00011
//    Answer: 3
//

    // Insert your Solution class here
    class Solution {
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) return 0;
            int row = grid.length;
            int col = grid[0].length;
            boolean[][] visited = new boolean[row][col];
            int num = 0;

            for (int i=0; i<row; i++) {
                for (int j=0; j<col; j++) {
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        num++;
                        //dfs
                        dfs(i,j,row,col,grid,visited);
                    }
                }
            }
            return num;
        }

        void dfs(int x, int y, int row, int col, char[][] grid, boolean[][] visited) {
            if (grid[x][y] == '0' || visited[x][y]) return;
            visited[x][y] = true;
            if (x-1>=0) dfs(x-1, y, row, col, grid, visited);
            if (x+1<row) dfs(x+1, y, row, col, grid, visited);
            if (y-1>=0) dfs(x, y-1, row, col, grid, visited);
            if (y+1<col) dfs(x, y+1, row, col, grid, visited);
        }
    }
    public static class UnitTest {
        @Test
        public void testNumberofIslands() {
            Solution s = new NumberofIslands().new Solution();
            char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
            int n = s.numIslands(grid);
        }
    }
}

