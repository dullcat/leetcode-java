package find_the_duplicate_number;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class FindtheDuplicateNumber {
//    Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
//
//        Example 1:
//
//        Input: [1,3,4,2,2]
//        Output: 2
//
//        Example 2:
//
//        Input: [3,1,3,4,2]
//        Output: 3
//        Note:
//
//    You must not modify the array (assume the array is read only).
//    You must use only constant, O(1) extra space.
//    Your runtime complexity should be less than O(n2).
//    There is only one duplicate number in the array, but it could be repeated more than once.

    // Insert your Solution class here
    class Solution {
        public int findDuplicate(int[] nums) {
            // sum(n) = (1+n) * n / 2;
            int[] count = new int[32];

            for (int j=0; j<32; j++) {
                for (int i=1; i<=nums.length-1; i++) {
                    if (((1<<j) & i) != 0) count[j]++;
                }
            }
            int res = 0;
            for (int j=0; j<32; j++) {
                for (int i=0; i<nums.length; i++) {
                    if (((1<<j) & nums[i]) != 0) count[j]--;
                    if (count[j] < 0) res |= 1<<j;
                }
            }
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testFindtheDuplicateNumber() {
            Solution s = new FindtheDuplicateNumber().new Solution();
        }
    }
}

