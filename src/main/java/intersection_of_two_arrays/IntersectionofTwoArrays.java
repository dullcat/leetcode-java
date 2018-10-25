package intersection_of_two_arrays;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class IntersectionofTwoArrays {
//    Given two arrays, write a function to compute their intersection.
//
//            Example 1:
//
//    Input: nums1 = [1,2,2,1], nums2 = [2,2]
//    Output: [2]
//    Example 2:
//
//    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//    Output: [9,4]
//    Note:
//
//    Each element in the result must be unique.
//    The result can be in any order.

    // Insert your Solution class here
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            if (nums1 == null || nums2 == null || nums1.length==0 || nums2.length==0)
                return new int[0];
            int[] min = nums1.length < nums2.length? nums1: nums2;
            int[] max = nums1.length < nums2.length? nums2: nums1;
            Set<Integer> set = new HashSet<Integer>(min.length);
            for (int i: min) {
                set.add(i);
            }
            Set<Integer> res = new HashSet<>();
            for (int i: max) {
                if (set.contains(i)) {
                    res.add(i);
                }
            }

            int[] r = new int[res.size()];
            int j = 0;
            for (int i: res) {
                r[j++] = i;
            }
            return r;
        }
    }
    public static class UnitTest {
        @Test
        public void testIntersectionofTwoArrays() {
            Solution s = new IntersectionofTwoArrays().new Solution();
        }
    }
}

