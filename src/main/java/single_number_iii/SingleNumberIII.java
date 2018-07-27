package single_number_iii;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class SingleNumberIII {
//    Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
//
//    Example:
//
//    Input:  [1,2,1,3,2,5]
//    Output: [3,5]
//    Note:
//
//    The order of the result is not important. So in the above example, [5, 3] is also correct.
//    Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

    // Insert your Solution class here
    class Solution {
        public int[] singleNumber(int[] nums) {
            // a & b, a^b
            int d = 0;
            for (int i: nums) d ^= i;

            int[] res = new int[2];
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testSingleNumberIII() {
            Solution s = new SingleNumberIII().new Solution();
        }
    }
}

