package random_pick_with_weight;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class RandomPickwithWeight {
//    Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.
//
//            Note:
//
//            1 <= w.length <= 10000
//            1 <= w[i] <= 10^5
//    pickIndex will be called at most 10000 times.
//            Example 1:
//
//    Input:
//            ["Solution","pickIndex"]
//            [[[1]],[]]
//    Output: [null,0]
//    Example 2:
//
//    Input:
//            ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
//            [[[1,3]],[],[],[],[],[]]
//    Output: [null,0,1,1,1,0]
//    Explanation of Input Syntax:
//
//    The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.

    // Insert your Solution class here
    class Solution {

        int[] d;
        int n;
        int max;
        Random r;
        public Solution(int[] w) {
            n = w.length;
            d = new int[n];
            d[0] = w[0];
            for (int i=1; i<w.length; i++) {
                d[i] = d[i-1] + w[i];
            }
            max = d[n-1];
            r = new Random();
        }

        public int pickIndex() {
            int i = r.nextInt(max) + 1;
            int low = 0;
            int high = n-1;
            while (low < high) {
                int mid = low + (high-low)/2;
                if (d[mid] < i) {
                    low = mid + 1;
                }
                else if (d[mid] > i) {
                    high = mid;
                }
                else {
                    return mid;
                }
            }

            return high;
        }
    }


    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(w);
     * int param_1 = obj.pickIndex();
     */
    public static class UnitTest {
        @Test
        public void testRandomPickwithWeight() {
            //Solution s = new RandomPickwithWeight().new Solution();
        }
    }
}

