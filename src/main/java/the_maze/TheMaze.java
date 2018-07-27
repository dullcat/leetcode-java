package the_maze;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TheMaze {
//    There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
//
//    Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
//
//    The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
//
//    Example 1
//
//    Input 1: a maze represented by a 2D array
//
//        0 0 1 0 0
//        0 0 0 0 0
//        0 0 0 1 0
//        1 1 0 1 1
//        0 0 0 0 0
//
//    Input 2: start coordinate (rowStart, colStart) = (0, 4)
//    Input 3: destination coordinate (rowDest, colDest) = (4, 4)
//
//    Output: true
//    Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.
//
//            Example 2
//
//    Input 1: a maze represented by a 2D array
//
//        0 0 1 0 0
//        0 0 0 0 0
//        0 0 0 1 0
//        1 1 0 1 1
//        0 0 0 0 0
//
//    Input 2: start coordinate (rowStart, colStart) = (0, 4)
//    Input 3: destination coordinate (rowDest, colDest) = (3, 2)
//
//    Output: false
//    Explanation: There is no way for the ball to stop at the destination.
//
//            Note:
//    There is only one ball and one destination in the maze.
//    Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
//    The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
//    The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.

    // Insert your Solution class here
    // V3 7ms
    class Solution {
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
            boolean[][] visited = new boolean[maze.length][maze[0].length];
            for (int i=0; i<4; i++) {
                if (dfs(maze, start[0], start[1], destination, i, visited)) return true;;
            }
            return false;
        }

        private boolean dfs(int[][] maze, int sr, int sc, int[] dest, int dir, boolean[][] visited) {
            if (sr==dest[0] && sc==dest[1]) {
                return true;
            }
            int row = maze.length;
            int col = maze[0].length;

            int nextR = sr + dirs[dir][0];
            int nextC = sc + dirs[dir][1];
            while (nextR>=0 && nextR<row && nextC>=0 && nextC<col && maze[nextR][nextC]==0) {
                sr = nextR;
                sc = nextC;
                nextR = nextR + dirs[dir][0];
                nextC = nextC + dirs[dir][1];
            }
            if (sr>=0 && sr<row && sc>=0 && sc<col && visited[sr][sc]) return false;
            visited[sr][sc] = true;
            for (int i=0; i<4; i++) {
                if (i!=dir && sr>=0 && sr<row && sc>=0 && sc<col && maze[sr][sc]==0) {
                    if (dfs(maze, sr, sc, dest, i, visited)) return true;
                }
            }
            return false;
        }
    }
    // V1 18ms
    class Solution1 {
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
            boolean[][][] visited = new boolean[maze.length][maze[0].length][4];
            for (int i=0; i<4; i++) {
                if (dfs(maze, start[0], start[1], destination, i, visited)) return true;;
            }
            return false;
        }

        private boolean dfs(int[][] maze, int sr, int sc, int[] dest, int dir, boolean[][][] visited) {
            int row = maze.length;
            int col = maze[0].length;
            if (sr>=0 && sr<row && sc>=0 && sc<col && visited[sr][sc][dir]) return false;

            int nextR = sr + dirs[dir][0];
            int nextC = sc + dirs[dir][1];
            if (nextR<0 || nextR>=row || nextC<0 || nextC>=col || maze[nextR][nextC]==1) {
                if (sr==dest[0] && sc==dest[1]) {
                    return true;
                }
                visited[sr][sc][dir] = true;
                for (int i=0; i<4; i++) {
                    if (i==dir) continue;
                    int newR = sr + dirs[i][0];
                    int newC = sc + dirs[i][1];
                    if (newR>=0 && newR<row && newC>=0 && newC<col && maze[newR][newC]==0 && !visited[newR][newC][i]) {
                        if (dfs(maze, newR, newC, dest, i, visited)) return true;
                    }
                }
                return false;
            }
            //if (maze[nextR][nextC] == 0) {
            return dfs(maze, nextR, nextC, dest, dir, visited);
        }
    }
    // V2 12ms
    class Solution2 {
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
            boolean[][][] visited = new boolean[maze.length][maze[0].length][4];
            for (int i=0; i<4; i++) {
                if (dfs(maze, start[0], start[1], destination, i, visited)) return true;;
            }
            return false;
        }

        private boolean dfs(int[][] maze, int sr, int sc, int[] dest, int dir, boolean[][][] visited) {
            int row = maze.length;
            int col = maze[0].length;
            if (sr>=0 && sr<row && sc>=0 && sc<col && visited[sr][sc][dir]) return false;
            visited[sr][sc][dir] = true;

            int nextR = sr + dirs[dir][0];
            int nextC = sc + dirs[dir][1];
            while (nextR>=0 && nextR<row && nextC>=0 && nextC<col && maze[nextR][nextC]==0) {
                sr = nextR;
                sc = nextC;
                nextR = nextR + dirs[dir][0];
                nextC = nextC + dirs[dir][1];
            }
            if (sr==dest[0] && sc==dest[1]) {
                return true;
            }
            for (int i=0; i<4; i++) {
                if (i==dir) continue;
                int newR = sr + dirs[i][0];
                int newC = sc + dirs[i][1];
                if (newR>=0 && newR<row && newC>=0 && newC<col && maze[newR][newC]==0 && !visited[newR][newC][i]) {
                    if (dfs(maze, newR, newC, dest, i, visited)) return true;
                }
            }
            return false;
        }
    }
    public static class UnitTest {
        @Test
        public void testTheMaze() {
            Solution s = new TheMaze().new Solution();
        }
    }
}

