package _3sum_closest;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class _3SumClosest {

    // Insert your Solution class here
    public class Solution {
        public int twoSum(int[] numbers, int target, int start) {
            int left = start, right = numbers.length - 1;
            int res = 0;
            int gap = Integer.MAX_VALUE;
            while (left < right) {
                if (numbers[left] + numbers[right] == target) {
                    return target;
                }
                if (Math.abs(numbers[left] + numbers[right] - target) < gap){
                    res = numbers[left] + numbers[right];
                    gap = Math.abs(res - target);
                }
                if (numbers[left] + numbers[right] < target) {
                    left++;
                }
                else right--;
            }
            return res;
        }

        public int threeSumClosest(int[] nums, int target) {
            if (nums == null || nums.length < 3) return Integer.MAX_VALUE;
            int res = nums[0]+nums[1]+nums[2];
            int n = nums.length;

            Arrays.sort(nums);
            for (int i=0; i<n-2; i++) {
                //int[] subNums = Arrays.copyOfRange(nums, i+1, n);
                int r = twoSum(nums, target-nums[i], i+1) + nums[i];

                if (r == target) return target;
                if (Math.abs(res-target) > Math.abs(r-target))
                    res = r;
            }
            return res;
        }
    }

    public static class UnitTest {
        @Test
        public void test_3SumClosest() {
            Solution s = new _3SumClosest().new Solution();
            assertEquals(2.5, 2.4999999, 1E-6);
        }
    }
}

