package flip_game_ii;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class FlipGameII {
//    You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
//
//    Write a function to determine if the starting player can guarantee a win.
//
//            Example:
//
//    Input: s = "++++"
//    Output: true
//    Explanation: The starting player can guarantee a win by flipping the middle "++" to become "+--+".
//    Follow up:
//    Derive your algorithm's runtime complexity.


    // Insert your Solution class here
    class Solution {
        public boolean canWin(String s) {
            return canWin(s.toCharArray());
        }

        private boolean canWin (char[] s) {
            for (int i=0; i<=s.length-2; i++) {
                if (s[i] == '+' && s[i+1] == '+') {
                    s[i] = s[i+1] = '-';
                    if (!canWin(s)) {
                        s[i] = s[i+1] = '+';
                        return true;
                    }
                    s[i] = s[i+1] = '+';
                }
            }
            return false;
        }
    }
    public static class UnitTest {
        @Test
        public void testFlipGameII() {
            Solution s = new FlipGameII().new Solution();
        }
    }
}

