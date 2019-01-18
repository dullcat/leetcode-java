package find_riders;

import java.io.Serializable;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class FindRiders implements Serializable{

/* <Uber>
Q2. Find all riders who can be reached.
You are given a 2D matrix. Each cell is one of the following.
	1. 'B' represents buildings.
	2. 'R' represents riders.
	3. ' ' represents blank space.
You are given a starting cell (I,J).
there is a maximum distance X that you can move.
Write a program that returns the total number of riders who can be reached from starting point.

*/

    public class Solution implements Serializable{
        int id;
        String name;
        int findRiders(int[][] matrix, int i, int j, int step) {
            Queue<int[]> queue = new LinkedList<>();
            int[][] visited = new int[matrix.length][matrix[0].length];
            int res = 0;
            int[] start = new int[2];
            start[0] = i;
            start[1] = j;
            queue.offer(start);
            visited[i][j] = 1;

            Queue<int[]> nextQueue = new LinkedList<>();
            int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
            while (!queue.isEmpty() && step >= 0) {
                int[] cell = queue.poll();
                if (matrix[cell[0]][cell[1]] == 'R') {
                    res++;
                }
                if (matrix[cell[0]][cell[1]] != 'B') {
                    for (int k=0; k<dirs.length; k++) {
                        int newX = cell[0] + dirs[k][0];
                        int newY = cell[1] + dirs[k][1];
                        if (newX < 0 || newX >= matrix.length || newY < 0 || newY >= matrix[0].length || visited[newX][newY]==1) continue;
                        visited[newX][newY] = 1;
                        int[] newCell = new int[2];
                        newCell[0] = newX;
                        newCell[1] = newY;
                        nextQueue.offer(newCell);
                    }
                }
                if (queue.isEmpty()) {
                    step--;
                    queue = nextQueue;
                    nextQueue = new LinkedList<>();
                }
            }

            return res;
        }

//        public static void main(String args[] ) throws Exception {
//            /* Enter your code here. Input can be hardcoded. Print output to STDOUT */
//            Solution s = new Solution();
//            int[][] matrix = {{' ','R',' '},{' ','R','R'},{'R',' ','R'}};
//            System.out.println(s.findRiders(matrix, 1,1,2));
//
//        }
    }
    // Insert your Solution class here

    public static class UnitTest {
        @Test
        public void testFindRiders() {
            Solution s = new FindRiders().new Solution();
        }
    }
}

