package contiguous_array;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ContiguousArray {
//    Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
//
//    Example 1:
//    Input: [0,1]
//    Output: 2
//    Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
//    Example 2:
//    Input: [0,1,0]
//    Output: 2
//    Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
//    Note: The length of the given binary array will not exceed 50,000.

    // Insert your Solution class here
    // O(n^2) TLE
    class Solution1 {
        public int findMaxLength(int[] nums) {
            if (nums == null || nums.length < 2) return 0;
            int[] count1 = new int[nums.length+1];
            for (int i=0; i<nums.length; i++) {
                count1[i+1] = count1[i] + nums[i];
            }

            int res = 0;
            for (int i=1; i<nums.length; i++) {
                for (int j=nums.length; j>=i+1; j--) {
                    if ((count1[j]-count1[i-1])*2 == (j-i+1)) {
                        res = Math.max(res, j-i+1);
                        break;
                    }
                }
            }

            return res;
        }
    }
    // O(n)
    class Solution {
        public int findMaxLength(int[] nums) {
            if (nums == null || nums.length < 2) return 0;

            Map<Integer, Integer> map = new HashMap<>();
            int res = 0;
            int diff = 0; // diff between 1 and 0
            for (int i=0; i<nums.length; i++) {
                if (nums[i] == 1) diff++;
                else diff--;
                if (diff == 0) {
                    res = i+1;
                }
                if (map.containsKey(diff)) {
                    res = Math.max(res, i-map.get(diff));
                }
                else {
                    map.put(diff, i);
                }
            }
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testContiguousArray() {
            Solution s = new ContiguousArray().new Solution();
        }
    }
}

