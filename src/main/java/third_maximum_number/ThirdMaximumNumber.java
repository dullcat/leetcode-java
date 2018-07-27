package third_maximum_number;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ThirdMaximumNumber {
//    Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
//
//    Example 1:
//    Input: [3, 2, 1]
//
//    Output: 1
//
//    Explanation: The third maximum is 1.
//    Example 2:
//    Input: [1, 2]
//
//    Output: 2
//
//    Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
//    Example 3:
//    Input: [2, 2, 3, 1]
//
//    Output: 1
//
//    Explanation: Note that the third maximum here means the third maximum distinct number.
//    Both numbers with value 2 are both considered as second maximum.

    // Insert your Solution class here
    class Solution {
        public int thirdMax(int[] nums) {
            if (nums.length == 1) return nums[0];
            if (nums.length == 2) return Math.max(nums[0], nums[1]);
            long m1=nums[0], m2=Long.MIN_VALUE, m3=Long.MIN_VALUE;
            boolean m3Exist = false;
            for (int i=1; i<nums.length; i++) {
                long cur = nums[i];
                long temp;
                if (cur == m1 || cur == m2 || cur == m3) continue;
                if (cur > m1) {
                    temp = m1;
                    m1 = cur;
                    cur = temp;
                }
                if (cur < m1 && cur > m2) {
                    temp = m2;
                    m2 = cur;
                    cur = temp;
                }
                if (cur < m2 && cur > m3) {
                    m3 = cur;
                    m3Exist = true;
                }
            }
            return m3Exist? (int)m3: (int)m1;
        }
    }
    public static class UnitTest {
        @Test
        public void testThirdMaximumNumber() {
            Solution s = new ThirdMaximumNumber().new Solution();
        }
    }
}

