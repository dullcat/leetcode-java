package maximum_subarray;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MaximumSubarray {

    // Insert your Solution class here
    public class Solution {
        public int maxSubArray(int[] nums) {
            int[] sum = new int[nums.length];
            sum[0] = nums[0];
            int max = nums[0];
            for (int i=1; i<nums.length; i++) {
                sum[i] = Math.max(sum[i-1] + nums[i], nums[i]);
                max = Math.max(max, sum[i]);
            }
            return max;
        }
    }

    // optimal solution
    public class Solution1 {
        public int maxSubArray(int[] nums) {
            int sum = nums[0];
            int max = nums[0];
            for (int i=1; i<nums.length; i++) {
                sum += nums[i];
                sum = Math.max(sum, nums[i]);
                max = Math.max(max, sum);
            }
            return max;
        }
    }
    public static class UnitTest {
        @Test
        public void testMaximumSubarray() {
            Solution s = new MaximumSubarray().new Solution();
        }
    }
}

