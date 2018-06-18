package shifting_letters;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ShiftingLetters {

    // Insert your Solution class here
    class Solution {
        public String shiftingLetters(String S, int[] shifts) {
            String res = "";
            int count = 0;
            for (int i=shifts.length-1; i>=0; i--) {
                count += shifts[i] % 26;
                res = shiftOneLetter(S.charAt(i), count) + res;
            }
            return res;
        }
        private char shiftOneLetter(char c, int i) {
            return (char) ((c-'a' + i) % 26 + 'a');
        }
    }
    public static class UnitTest {
        @Test
        public void testShiftingLetters() {
            Solution s = new ShiftingLetters().new Solution();
        }
    }
}

