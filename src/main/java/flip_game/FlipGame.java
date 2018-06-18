package flip_game;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class FlipGame {

//    You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
//
//    Write a function to compute all possible states of the string after one valid move.
//
//            Example:
//
//    Input: s = "++++"
//    Output:
//            [
//            "--++",
//            "+--+",
//            "++--"
//            ]
//    Note: If there is no valid move, return an empty list [].
//
    // Insert your Solution class here
    class Solution {
        public List<String> generatePossibleNextMoves(String s) {
            char[] arr = s.toCharArray();
            List<String> res = new ArrayList<>();
            for (int i=0; i<arr.length-1; i++) {
                if (arr[i] == arr[i+1] && arr[i]=='+') {
                    arr[i] = arr[i+1] = '-';
                    res.add(new String(arr));
                    arr[i] = arr[i+1] = '+';
                }
            }
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testFlipGame() {
            Solution s = new FlipGame().new Solution();
        }
    }
}

