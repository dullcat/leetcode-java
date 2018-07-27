package intersection_of_two_arrays_lintc;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class IntersectionofTwoArraysLintC {
//    Description
//    Given two arrays, write a function to compute their intersection.
//
//    Each element in the result must be unique.
//    The result can be in any order.
//    Have you met this question in a real interview?
//    Example
//    Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
//
//    Challenge
//    Can you implement it in three different algorithms?

    // Insert your Solution class here
    public class Solution {

        /*
         * @param nums1: an integer array
         * @param nums2: an integer array
         * @return: an integer array
         */
        public int[] intersection(int[] nums1, int[] nums2) {
            // write your code here
            Set<Integer> res = new HashSet<>();
            int[] a = new int[0];
            if (nums1 == null ||nums2 == null || nums1.length == 0 || nums2.length == 0)
                return a;
            Set<Integer> set = new HashSet<>();
            if (nums1.length > nums2.length) {
                int[] t = nums1;
                nums1 = nums2;
                nums2 = t;
            }

            for (int i : nums1)
                set.add(i);
            for (int i : nums2) {
                if (set.contains(i))
                    res.add(i);
            }
            int[] ret = new int[res.size()];
            int i = 0;
            for (int num : res) {
                ret[i++] = num;
            }
            return ret;
        }
    }
    public static class UnitTest {
        @Test
        public void testIntersectionofTwoArraysLintC() {
            Solution s = new IntersectionofTwoArraysLintC().new Solution();
        }
    }
}

