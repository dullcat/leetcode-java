package island_perimeter;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class IslandPerimeter {
//    You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
//
//    Example:
//
//            [[0,1,0,0],
//            [1,1,1,0],
//            [0,1,0,0],
//            [1,1,0,0]]
//
//    Answer: 16
//    Explanation: The perimeter is the 16 yellow stripes in the image below:

    // Insert your Solution class here
    class Solution {
        public int islandPerimeter(int[][] grid) {
            if (grid.length == 0 || grid[0].length == 0) return 0;
            int res = 0;
            for (int i=0; i<grid.length; i++) {
                for (int j=0; j<grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        res += countSide(grid, i, j);
                    }
                }
            }
            return res;
        }
        private int countSide(int[][] grid, int i, int j) {
            int res = 0;
            if (i==0 || grid[i-1][j]==0) res++;
            if (i==grid.length-1 || grid[i+1][j]==0) res++;
            if (j==0 || grid[i][j-1]==0) res++;
            if (j==grid[0].length-1 || grid[i][j+1]==0) res++;
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testIslandPerimeter() {
            Solution s = new IslandPerimeter().new Solution();
        }
    }
}

