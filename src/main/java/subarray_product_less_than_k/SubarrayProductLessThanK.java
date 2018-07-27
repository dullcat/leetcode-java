package subarray_product_less_than_k;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class SubarrayProductLessThanK {
//    Your are given an array of positive integers nums.
//
//    Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
//
//    Example 1:
//    Input: nums = [10, 5, 2, 6], k = 100
//    Output: 8
//    Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
//    Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
//    Note:
//
//            0 < nums.length <= 50000.
//            0 < nums[i] < 1000.
//            0 <= k < 10^6.

    // Insert your Solution class here
    // O(n), count base on left edge.
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            if (nums.length == 0 || k<=1) return 0;
            int l = 0;
            int res = 0;
            long cur = 1;
            for (int r=0; r<nums.length; r++) {
                cur *= nums[r];
                while (cur >= k && l<=r) {
                    cur /= nums[l++];
                }
                res += r-l+1;
            }
            return res;
        }
    }
    // O(n), count base on left edge.
    class Solution2 {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            if (nums.length == 0 || k<=1) return 0;
            int l = 0;
            int res = 0;
            long cur = 1;
            for (int r=0; r<=nums.length; r++) {
                if (r<nums.length) cur *= nums[r];
                while ((cur >= k && l<=r) || (r==nums.length && l<r)) {
                    res += r-l;
                    //System.out.println(res);
                    cur /= nums[l];
                    l++;
                }
            }
            return res;
        }
    }

    // O(n^2) TLE
    class Solution1 {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int l = 0;
            int r = 0;
            int res = 0;
            for (int i=0; i<nums.length; i++) {
                int cur = 1;
                for (int j=i; j<nums.length; j++) {
                    cur *= nums[j];
                    if (cur < k) res++;
                    else break;
                }
            }
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testSubarrayProductLessThanK() {
            Solution s = new SubarrayProductLessThanK().new Solution();
        }
    }
}

