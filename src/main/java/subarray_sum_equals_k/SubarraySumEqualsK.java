package subarray_sum_equals_k;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class SubarraySumEqualsK {
//    Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
//
//            Example 1:
//    Input:nums = [1,1,1], k = 2
//    Output: 2
//    Note:
//    The length of the array is in range [1, 20,000].
//    The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

    // Insert your Solution class here
    class Solution {
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            int res = 0;
            int sum = 0;
            for (int i=0; i<nums.length; i++) {
                sum += nums[i];
                if (sum == k) res++;
                if (map.containsKey(sum-k))
                    res += map.get(sum-k);

                if (!map.containsKey(sum)) {
                    map.put(sum, 1);
                }
                else {
                    map.put(sum, map.get(sum)+1);
                }
            }
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testSubarraySumEqualsK() {
            Solution s = new SubarraySumEqualsK().new Solution();
        }
    }
}

