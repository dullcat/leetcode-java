package shortest_unsorted_continuous_subarray;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ShortestUnsortedContinuousSubarray {
    /***

     */
    // Insert your Solution class here
    public class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int[] leftMax = new int[nums.length];
            int[] rightMin = new int[nums.length];
            int curMax = Integer.MIN_VALUE;
            for(int i=0; i<nums.length; i++) {
                leftMax[i] = curMax;
                curMax = Math.max(curMax, nums[i]);
            }
            int curMin = Integer.MAX_VALUE;
            for(int i=nums.length-1; i>=0; i--) {
                rightMin[i] = curMin;
                curMin = Math.min(curMin, nums[i]);
            }

            int left = 0, right = nums.length-1;
            while (left < nums.length && leftMax[left] <= nums[left] && nums[left] <= rightMin[left]) left++;
            while (right >=0 && leftMax[right] <= nums[right] && nums[right] <= rightMin[right]) right--;
            if (left>=right) return 0;
            return right-left+1;
        }
    }
    public static class UnitTest {
        @Test
        public void testShortestUnsortedContinuousSubarray() {
            Solution s = new ShortestUnsortedContinuousSubarray().new Solution();
        }
    }
}

