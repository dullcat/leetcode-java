package minimum_size_subarray_sum;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MinimumSizeSubarraySum {
//    Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
//
//    Example:
//
//    Input: s = 7, nums = [2,3,1,2,4,3]
//    Output: 2
//    Explanation: the subarray [4,3] has the minimal length under the problem constraint.
//    Follow up:
//    If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).

    // Insert your Solution class here
    class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int i=0, j=0, min=0;

            int sum=0;
            while (j<nums.length) {
                while (j<nums.length && sum < s) {
                    sum += nums[j++];
                }
                if (j == nums.length && sum < s) return min;
                if (min == 0)
                    min = j-i;
                while (i<j && sum >= s) {
                    min = Math.min(min, j-i);
                    sum -= nums[i++];
                }
            }
            return min;
        }
    }
    public static class UnitTest {
        @Test
        public void testMinimumSizeSubarraySum() {
            Solution s = new MinimumSizeSubarraySum().new Solution();
        }
    }
}

