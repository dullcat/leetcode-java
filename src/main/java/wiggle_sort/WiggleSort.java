package wiggle_sort;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class WiggleSort {
//    Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
//
//    Example:
//
//    Input: nums = [3,5,2,1,6,4]
//    Output: One possible answer is [3,5,1,6,2,4]

    // Insert your Solution class here
    class Solution {
        public void wiggleSort(int[] nums) {
            if (nums == null || nums.length < 2) return;
            boolean asc = true;
            for (int i=0; i<nums.length-1; i++) {
                if (asc && nums[i]>nums[i+1] || !asc && nums[i]<nums[i+1]) {
                    swap(nums, i, i+1);
                }
                asc = !asc;
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    public static class UnitTest {
        @Test
        public void testWiggleSort() {
            Solution s = new WiggleSort().new Solution();
        }
    }
}

