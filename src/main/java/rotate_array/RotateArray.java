package rotate_array;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class RotateArray {
//    Given an array, rotate the array to the right by k steps, where k is non-negative.
//
//            Example 1:
//
//    Input: [1,2,3,4,5,6,7] and k = 3
//    Output: [5,6,7,1,2,3,4]
//    Explanation:
//    rotate 1 steps to the right: [7,1,2,3,4,5,6]
//    rotate 2 steps to the right: [6,7,1,2,3,4,5]
//    rotate 3 steps to the right: [5,6,7,1,2,3,4]
//    Example 2:
//
//    Input: [-1,-100,3,99] and k = 2
//    Output: [3,99,-1,-100]
//    Explanation:
//    rotate 1 steps to the right: [99,-1,-100,3]
//    rotate 2 steps to the right: [3,99,-1,-100]
//    Note:
//
//    Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
//    Could you do it in-place with O(1) extra space?

    // Insert your Solution class here
    class Solution {
        public void rotate(int[] nums, int k) {
            if (nums == null || nums.length < 2 || k == 0) return;

            int n = nums.length;
            k = k % n;
            if (k == 0) return;
            if (n % k == 0) {
                for (int i=0; i<k; i++) {
                    int cur = nums[i];
                    for (int j=i; j<n; j+=k) {
                        int t = nums[(j + k) % n];
                        nums[(j + k) % n] = cur;
                        cur = t;
                    }
                }
            }
            else {
                int cur = nums[0];
                for (int i=0, next=0; i<n; i++) {
                    next = (next + k) % n;
                    int t = nums[next];
                    nums[next] = cur;
                    cur = t;
                }
            }
        }
    }
    public static class UnitTest {
        @Test
        public void testRotateArray() {
            Solution s = new RotateArray().new Solution();
        }
    }
}

