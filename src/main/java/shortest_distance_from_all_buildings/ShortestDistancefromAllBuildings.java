package shortest_distance_from_all_buildings;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ShortestDistancefromAllBuildings {
//    You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
//
//    Each 0 marks an empty land which you can pass by freely.
//    Each 1 marks a building which you cannot pass through.
//    Each 2 marks an obstacle which you cannot pass through.
//    Example:
//
//    Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
//
//            1 - 0 - 2 - 0 - 1
//            |   |   |   |   |
//            0 - 0 - 0 - 0 - 0
//            |   |   |   |   |
//            0 - 0 - 1 - 0 - 0
//
//    Output: 7
//
//    Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
//    the point (1,2) is an ideal empty land to build a house, as the total
//    travel distance of 3+3+1=7 is minimal. So return 7.
//    Note:
//    There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
    // Insert your Solution class here
class Solution {
    public int shortestDistance(int[][] grid) {
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (!bfs(grid, i, j)) return -1;
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] < 0) {
                    res = Math.max(res, grid[i][j]);
                }
            }
        }
        if (res == Integer.MIN_VALUE) return -1;
        return -res;
    }

    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    private boolean bfs(int[][] grid, int row, int col) {
        int rLen = grid.length;
        int cLen = grid[0].length;
        if (row<0 || row>=rLen || col<0 || col>=cLen) return false;

        int[][] curGrid = new int[grid.length][grid[0].length];
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(row*cLen + col);
        curGrid[row][col] = 1;
        while (!q.isEmpty()) {
            int i = q.poll();
            int r = i / cLen;
            int c = i % cLen;
            int d = (grid[r][c]<=0)?curGrid[r][c]:0;
            for (int j=0; j<dir.length; j++) {
                int newR = r + dir[j][0];
                int newC = c + dir[j][1];
                if (newR>=0 && newR<rLen && newC>=0 && newC<cLen && grid[newR][newC]<=0 && curGrid[newR][newC]==0) {
                    curGrid[newR][newC] = d-1;
                    grid[newR][newC] += curGrid[newR][newC];
                    q.offer(newR * cLen + newC);
                }
            }
        }

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j]<=0 && curGrid[i][j] == 0) {
                    grid[i][j] = 3;// not reachable to at least one building
                }
            }
        }
        return true;
    }
}
// [
// [1,1,1,1,1,0],
// [0,0,0,0,0,1],
// [0,1,1,0,0,1],
// [1,0,0,1,0,1],
// [1,0,1,0,0,1],
// [1,0,0,0,0,1],
// [0,1,1,1,1,0]]
public static class UnitTest {
        @Test
        public void testShortestDistancefromAllBuildings() {
            Solution s = new ShortestDistancefromAllBuildings().new Solution();
            int[][] grid = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
            int[][] g1 = {{1,1,1,1,1,0},{0,0,0,0,0,1},{0,1,1,0,0,1},{1,0,0,1,0,1},{1,0,1,0,0,1},{1,0,0,0,0,1},{0,1,1,1,1,0}};
            assertEquals(s.shortestDistance(g1), 88);
        }
    }
}

