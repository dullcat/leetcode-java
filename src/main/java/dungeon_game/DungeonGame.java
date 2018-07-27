package dungeon_game;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class DungeonGame {
//    The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
//
//    The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
//
//    Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
//
//    In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
//
//
//
//    Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
//
//    For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
//
//            -2 (K)	-3	    3
//            -5	    -10	    1
//            10	    30	    -5 (P)
//
//
//    Note:
//
//    The knight's health has no upper bound.
//    Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.

    // Insert your Solution class here
    class Solution {
        public int calculateMinimumHP(int[][] dungeon) {
            if (dungeon.length == 0 || dungeon[0].length == 0) return 0;
            int row = dungeon.length;
            int col = dungeon[0].length;
            int[][] hp = new int[row][col];
            int[][] min = new int[row][col];
            min[0][0] = dungeon[0][0] <= 0? 1-dungeon[0][0]: 0;
            hp[0][0] = dungeon[0][0];

            for (int i=1; i<col; i++) {
                hp[0][i] = hp[0][i-1] + dungeon[0][i];
                int cur = min[0][i-1] + hp[0][i];
                min[0][i] = cur <= 0? 1-cur + min[0][i-1]: min[0][i-1];
            }
            for (int i=1; i<row; i++) {
                hp[i][0] = hp[i-1][0] + dungeon[i][0];
                int cur = min[i-1][0] + hp[i][0];
                min[i][0] = cur <= 0? 1-cur + min[i-1][0]: min[i-1][0];
                for (int j=1; j<col; j++) {
                    int curMin, curHp;
                    if ((min[i-1][j] < min[i][j-1]) || min[i-1][j] == min[i][j-1] && hp[i-1][j] > hp[i][j-1]) {
                        curMin = min[i-1][j];
                        curHp = hp[i-1][j];
                    }
                    else {
                        curMin = min[i][j-1];
                        curHp = hp[i][j-1];
                    }
                    hp[i][j] = curHp + dungeon[i][j];
                    cur = curMin + hp[i][j];
                    min[i][j] = cur <= 0? 1-cur + curMin: curMin;
                }
            }

            return min[row-1][col-1];
        }
    }
    public static class UnitTest {
        @Test
        public void testDungeonGame() {
            Solution s = new DungeonGame().new Solution();
            // 1  -3  3
            // 0  -2  0
            // -3 -3  -3
        }
    }
}

