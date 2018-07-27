package kth_largest_element_in_an_array;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class KthLargestElementinanArray {
//    Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
//    Example 1:
//
//    Input: [3,2,1,5,6,4] and k = 2
//    Output: 5
//    Example 2:
//
//    Input: [3,2,3,1,2,4,5,5,6] and k = 4
//    Output: 4
//    Note:
//    You may assume k is always valid, 1 ≤ k ≤ array's length.
    // Insert your Solution class here

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length - 1;
        while (true) {
            int i = partition(nums, lo, hi);
            if (i == k-1) return nums[i];
            else if (i<k-1) lo = i + 1;
            else hi = i - 1;
        }
        //return 0;
    }

    private int partition(int[] nums, int lo, int hi) {
        int p = nums[lo];
        int i=lo;
        int j=hi;
        while (i < j) {
            while (i<=j && nums[i] >= p) i++;
            while (i<=j && nums[j] <= p) j--;
            if (i<j) {
                swap(nums, i, j);
            }
        }

        swap(nums, lo, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
    public static class UnitTest {
        @Test
        public void testKthLargestElementinanArray() {
            Solution s = new KthLargestElementinanArray().new Solution();
        }
    }
}

