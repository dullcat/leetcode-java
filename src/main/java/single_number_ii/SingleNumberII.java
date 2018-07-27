package single_number_ii;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class SingleNumberII {
//    Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
//
//    Note:
//
//    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//
//    Example 1:
//
//    Input: [2,2,3,2]
//    Output: 3
//    Example 2:
//
//    Input: [0,1,0,1,0,1,99]
//    Output: 99

    // Insert your Solution class here
    // Space int[1]
    class Solution {
        public int singleNumber(int[] nums) {
            int res = 0;
            for (int j=0; j<32; j++) {
                int count = 0;
                for (int i: nums) {
                    if (((1<<j) & i) != 0) {
                        count++;
                    }
                }
                if (count % 3 == 1) {
                    res |= (1<<j);
                }
            }

            return res;
        }
    }
    // Space int[32]
    class Solution1 {
        public int singleNumber(int[] nums) {
            int[] count = new int[32];
            for (int i: nums) {
                for (int j=0; j<32; j++) {
                    if (((1<<j) & i) != 0) {
                        count[j]++;
                    }
                }
            }
            int res = 0;
            for (int i=0; i<32; i++) {
                if (count[i] % 3 == 1) {
                    res |= (1<<i);
                }
            }

            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testSingleNumberII() {
            Solution s = new SingleNumberII().new Solution();
        }
    }
}

