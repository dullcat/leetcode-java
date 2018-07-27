package maximum_size_subarray_sum_equals_k;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MaximumSizeSubarraySumEqualsk {
//    Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
//
//    Note:
//    The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
//
//    Example 1:
//
//    Input: nums = [1, -1, 5, -2, 3], k = 3
//    Output: 4
//    Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
//    Example 2:
//
//    Input: nums = [-2, -1, 2, 1], k = 1
//    Output: 2
//    Explanation: The subarray [-1, 2] sums to 1 and is the longest.
//    Follow Up:
//    Can you do it in O(n) time?

    // Insert your Solution class here

    // O(n)
    class Solution {
        public int maxSubArrayLen(int[] nums, int k) {
            if (nums == null || nums.length == 0) return 0;
            Map<Integer, Integer> map = new HashMap<>();
            int sum =0;
            int res = 0;
            for (int i=0; i<=nums.length-1; i++) {
                sum += nums[i];
                if (sum == k) {
                    res = Math.max(res, i+1);
                }
                if (map.containsKey(sum-k)) {
                    res = Math.max(res, i-map.get(sum-k));
                }
                if (!map.containsKey(sum))
                    map.put(sum, i);
            }
            return res;
        }
    }

    // O(n^2)
    class Solution1 {
        public int maxSubArrayLen(int[] nums, int k) {
            if (nums == null || nums.length == 0) return 0;
            int[] sum = new int[nums.length+1];
            sum[0] = 0;
            for (int i=1; i<=nums.length; i++) {
                sum[i] = sum[i-1] + nums[i-1];
            }

            int res = 0;
            for (int i=0; i<=nums.length-1; i++) {
                for (int j=nums.length; j>i+res; j--) {
                    if (sum[j]-sum[i] == k) {
                        res = Math.max(res, j-i);
                        break;
                    }
                }
            }
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testMaximumSizeSubarraySumEqualsk() {
            Solution s = new MaximumSizeSubarraySumEqualsk().new Solution();
        }
    }
}

