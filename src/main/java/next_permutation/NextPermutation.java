package next_permutation;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class NextPermutation {

    // Insert your Solution class here
    public class Solution {
        public void nextPermutation(int[] nums) {
            if (nums.length <= 1) return;
            int i = 0;
            for(; i<nums.length-1; i++) {
                if (nums[i] > nums[i+1]) {
                    break;
                }
            }
        }
    }
    public static class UnitTest {
        @Test
        public void testNextPermutation() {
            Solution s = new NextPermutation().new Solution();
        }
    }
}

