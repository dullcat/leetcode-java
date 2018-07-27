package shortest_unsorted_continuous_subarray;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ShortestUnsortedContinuousSubarray {
//    Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
//
//    You need to find the shortest such subarray and output its length.
//
//    Example 1:
//    Input: [2, 6, 4, 8, 10, 9, 15]
//    Output: 5
//    Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
//    Note:
//    Then length of the input array is in range [1, 10,000].
//    The input array may contain duplicates, so ascending order here means <=.
// Insert your Solution class here
    // O(n) one pass
    class Solution {
        public int findUnsortedSubarray1(int[] A) {
            int n = A.length, beg = -1, end = -2, min = A[n-1], max = A[0];
            for (int i=1;i<n;i++) {
                max = Math.max(max, A[i]);
                min = Math.min(min, A[n-1-i]);
                if (A[i] < max) end = i;
                if (A[n-1-i] > min) beg = n-1-i;
            }
            return end - beg + 1;
        }
        public int findUnsortedSubarray2(int[] nums) {
            int i = 0, j = -1, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

            for (int l = 0, r = nums.length - 1; r >= 0; l++, r--) {
                max = Math.max(max, nums[l]);
                if (nums[l] != max) j = l;

                min = Math.min(min, nums[r]);
                if (nums[r] != min) i = r;
            }

            return (j - i + 1);
        }
    }

    // O(nlogn)
class Solution3 {
    public int findUnsortedSubarray(int[] nums) {
        int[] sortNums = nums.clone();
        Arrays.sort(sortNums);
        int i = 0;
        while (i<nums.length && nums[i] == sortNums[i]) i++;
        if (i == nums.length) return 0;

        int j = nums.length-1;
        while (j>=0 && nums[j] == sortNums[j]) j--;
        if (j < 0) return 0;

        return (j-i+1);
    }
}

    // O(n) 2 pass, easy to understnd
    class Solution2 {
        public int findUnsortedSubarray(int[] nums) {
            int l = 0, r = nums.length - 1, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

            while (l < r && nums[l] <= nums[l + 1]) l++;

            if (l >= r) return 0;

            while (nums[r] >= nums[r - 1]) r--;

            for (int k = l; k <= r; k++) {
                max = Math.max(max, nums[k]);
                min = Math.min(min, nums[k]);
            }

            while (l >= 0 && min < nums[l]) l--;
            while (r < nums.length && nums[r] < max) r++;

            return (r - l - 1);
        }
    }
    // O(n) 3 passes
    public class Solution1 {
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

