package majority_element;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MajorityElement {
//    Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
//    You may assume that the array is non-empty and the majority element always exist in the array.
//
//    Example 1:
//
//    Input: [3,2,3]
//    Output: 3
//    Example 2:
//
//    Input: [2,2,1,1,1,2,2]
//    Output: 2

    // Insert your Solution class here
    class Solution {
        public int majorityElement(int[] nums) {
            int m = nums[0];
            int c = 1;
            for (int i=1; i<nums.length; i++) {
                if (c == 0) {
                    m = nums[i];
                    c++;
                }
                else {
                    if (m == nums[i]) c++;
                    else c--;
                }
            }
            return m;
        }
    }
    public static class UnitTest {
        @Test
        public void testMajorityElement() {
            Solution s = new MajorityElement().new Solution();
        }
    }
}

