package oa_cell_complete;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class OACellComplete {

    // Insert your Solution class here
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
    // SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
    public class Solution
    {
        // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
        public List<Integer> cellCompete(int[] states, int days)
        {
            // WRITE YOUR CODE HERE
            List<Integer> res = new ArrayList<>();
            if (states == null || states.length == 0) return res;
            if (days <= 0) {
                return genResult(states);
            }
            if (states.length == 1 && days >= 1) {
                states[0] = 0;
                return genResult(states);
            }

            for (int i=0; i<days; i++) {
                states = flip(states);
            }

            return genResult(states);
        }

        private int[] flip(int[] states) {
            int[] res = new int[states.length];
            for (int i=0; i<states.length; i++) {
                if (i==0) {
                    res[i] = states[i+1];
                }
                else if (i == states.length-1) {
                    res[i] = states[i-1];
                }
                else {
                    res[i] = states[i-1] == states[i+1]? 0:1;
                }
            }
            return res;
        }

        private List<Integer> genResult(int[] states) {
            List<Integer> res = new ArrayList<>();
            for (int i: states) {
                res.add(i);
            }
            return res;
        }
        // METHOD SIGNATURE ENDS
    }
    public static class UnitTest {
        @Test
        public void testOACellComplete() {
            Solution s = new OACellComplete().new Solution();
        }
    }
}

