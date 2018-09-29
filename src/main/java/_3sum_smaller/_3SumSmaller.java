package _3sum_smaller;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class _3SumSmaller {
//    Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
//
//    Example:
//
//    Input: nums = [-2,0,1,3], and target = 2
//    Output: 2
//    Explanation: Because there are two triplets which sums are less than 2:
//            [-2,0,1]
//            [-2,0,3]
//    Follow up: Could you solve it in O(n2) runtime?
//

    // Insert your Solution class here
    class Solution {
        public int threeSumSmaller(int[] nums, int target) {
            if (nums == null || nums.length < 3) return 0;

            Arrays.sort(nums);
            int n = nums.length;
            int res = 0;
            for (int i=0; i<n-2; i++) {
                int left = i+1;
                int right = n-1;
                while (left < right) {
                    if (nums[i] + nums[left] + nums[right] >= target) right--;
                    else {
                        res += right - left;
                        left++;
                    }
                }
            }
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void test_3SumSmaller() {
            Solution s = new _3SumSmaller().new Solution();
        }
    }
}

