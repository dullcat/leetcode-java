package surrounded_regions;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class SurroundedRegions {

    // Insert your Solution class here
    public class Solution {
        public void solve(char[][] board) {
            if (board == null || board.length==0 || board[0].length==0) return;
            int rows = board.length;
            int cols = board[0].length;
            for(int i=0; i<rows; i++) {
                if (board[i][0] == 'O') dfs(board, i, 0);
                if (board[i][cols-1] == 'O') dfs(board, i, cols-1);
            }
            for(int j=1; j<cols-1; j++) {
                if (board[0][j] == 'O') dfs(board, 0, j);
                if (board[rows-1][j] == 'O') dfs(board, rows-1, j);
            }

            for(int i=0; i<rows; i++)
                for(int j=0; j<cols; j++) {
                    if (board[i][j]=='F') {
                        board[i][j] = 'O';
                    }
                    else if (board[i][j]=='O') {
                        board[i][j] = 'X';
                    }
                }
        }

        void dfs(char[][] board, int row, int col) {
            if (row<0 || row>board.length-1 || col<0 || col>board[0].length-1) return;
            if (board[row][col]=='X' || board[row][col]=='F') return;
            board[row][col] = 'F';
            if (row-1>0) dfs(board, row-1, col);
            if (row+1<board.length-1) dfs(board, row+1, col);
            if (col-1>0) dfs(board, row, col-1);
            if (col+1<board[0].length-1) dfs(board, row, col+1);
            return;
        }
    }
    public static class UnitTest {
        @Test
        public void testSurroundedRegions() {
            Solution s = new SurroundedRegions().new Solution();
        }
    }
}

