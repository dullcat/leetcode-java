package oa_minimum_distance;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class OAMinimumDistance {

    // Insert your Solution class here
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
    // CLASS BEGINS, THIS CLASS IS REQUIRED
    public class Solution
    {
        private class Pair {
            int row;
            int col;
            int distance;
            Pair(int r, int c, int d) {
                row = r;
                col = c;
                distance = d;
            }
        }
        // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int minimumDistance(int numRows, int numColumns, List<List<Integer>> area)
        {
            // WRITE YOUR CODE HERE

            if (area == null || area.size() == 0 || area.get(0).size() == 0)
                return -1;
            if (area.size() != numRows || area.get(0).size() != numColumns)
                return -1;

            // BFS from start point.
            boolean[][] visited = new boolean[numRows][numColumns];
            Queue<Pair> q = new LinkedList<>();
            Pair start = new Pair(0,0,0);
            q.offer(start);

            while (!q.isEmpty()) {
                Pair cur = q.poll();
                if (area.get(cur.row).get(cur.col) == 9) {
                    return cur.distance;
                }

                visited[cur.row][cur.col] = true;

                // Check 4 directions. If accessible then add to queue.
                for (int[] dir : dirs) {
                    int newRow = cur.row + dir[0];
                    int newCol = cur.col + dir[1];
                    if (newRow>=0 && newRow<numRows && newCol>=0 && newCol<numColumns
                            && !visited[newRow][newCol]
                            && area.get(newRow).get(newCol) != 0) {
                        Pair p = new Pair(newRow, newCol, cur.distance+1);
                        q.offer(p);
                    }
                }
            }

            return -1;
        }
        // METHOD SIGNATURE ENDS
    }
    public static class UnitTest {
        @Test
        public void testOAMinimumDistance() {
            Solution s = new OAMinimumDistance().new Solution();
            List<Integer> row1 = new ArrayList<>(); row1.add(1); row1.add(0); row1.add(0);
            List<Integer> row2 = new ArrayList<>(); row2.add(1); row2.add(0); row2.add(0);
            List<Integer> row3 = new ArrayList<>(); row3.add(1); row3.add(9); row3.add(1);
            List<List<Integer>> area = new ArrayList<>(); area.add(row1); area.add(row2); area.add(row3);
            int d = s.minimumDistance(3,3,area);
            assertEquals(3, d);
        }
    }
}

