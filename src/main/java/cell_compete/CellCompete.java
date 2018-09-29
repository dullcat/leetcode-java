package cell_compete;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.List;

public class CellCompete {

    // Insert your Solution class here
    // SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
    public class Solution
    {
        // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
        public List<Integer> cellCompete(int[] states, int days)
        {
            // WRITE YOUR CODE HERE
            List<Integer> res = new ArrayList();
            if (states.length >= 2) {
                for (int i=0; i<days; i++) {
                    states = flip(states);
                }
            }

            for (int i: states) {
                res.add(i);
            }
            return res;
        }
        private int[] flip(int[] states) {
            int len = states.length;
            int[] res = new int[len];
            res[0] = states[1];
            res[len-1] = states[len-2];
            for (int i=1; i<states.length-1; i++) {
                res[i] = states[i-1] | states[i+1];
            }
            return res;
        }
        // METHOD SIGNATURE ENDS
    }
    public static class UnitTest {
        @Test
        public void testCellCompete() {
            Solution s = new CellCompete().new Solution();
        }
    }
}

