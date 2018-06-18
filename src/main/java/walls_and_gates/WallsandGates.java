package walls_and_gates;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class WallsandGates {
//    You are given a m x n 2D grid initialized with these three possible values.
//
//-1 - A wall or an obstacle.
//0 - A gate.
//    INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
//    Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
//
//            Example:
//
//    Given the 2D grid:
//
//    INF  -1  0  INF
//    INF INF INF  -1
//    INF  -1 INF  -1
//            0  -1 INF INF
//    After running your function, the 2D grid should be:
//
//            3  -1   0   1
//            2   2   1  -1
//            1  -1   2  -1
//            0  -1   3   4

    // Insert your Solution class here
    class Solution {
        public void wallsAndGates(int[][] rooms) {
            for (int i=0; i<rooms.length; i++) {
                for (int j=0; j<rooms[0].length; j++)
                    if (rooms[i][j] == 0)
                        dfs(rooms, i, j, 0);
            }
        }

        int[][] dirs = {{0,-1},{0,1},{1,0},{-1,0}};
        private void dfs(int[][] rooms, int row, int col, int dist) {
            if (row<0 || row>=rooms.length || col<0 || col>=rooms[0].length || rooms[row][col] < 0 || rooms[row][col] < dist) return;
            if (dist>0 && rooms[row][col]<=dist) return;

            rooms[row][col] = dist;
            for (int i=0; i<4; i++) {
                dfs(rooms, row+dirs[i][0], col+dirs[i][1], dist+1);
            }
        }
    }
    public static class UnitTest {
        @Test
        public void testWallsandGates() {
            Solution s = new WallsandGates().new Solution();
        }
    }
}

