package majority_element_ii;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MajorityElementII {
//    Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
//
//            Note: The algorithm should run in linear time and in O(1) space.
//
//    Example 1:
//
//    Input: [3,2,3]
//    Output: [3]
//    Example 2:
//
//    Input: [1,1,1,3,3,2,2,2]
//    Output: [1,2]

    // Insert your Solution class here
    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            List<Integer> res = new ArrayList<>();
            if (nums == null || nums.length == 0) return res;

            int[] m = new int[2];
            int[] c = new int[2];
            for (int i=0; i<nums.length; i++) {
                insertOrDelete(m, c, nums[i]);
            }
            for (int i=0; i<2; i++) {
                if (c[i] > 0) {
                    int count = 0;
                    for (int j: nums) {
                        if (m[i] == j) count++;
                    }
                    if (count > nums.length/3) res.add(m[i]);
                }
            }
            return res;
        }

        private int insertOrDelete(int[] m, int[] c, int num) {
            for (int i=0; i<m.length; i++) {
                if (m[i] == num && c[i] > 0) {
                    c[i]++;
                    return i;
                }
            }
            for (int i=0; i<m.length; i++) {
                if (c[i] == 0) {
                    m[i] = num;
                    c[i]++;
                    return i;
                }
            }
            c[0]--;
            c[1]--;
            return -1;
        }
    }
    // Try 1
    class Solution1 {
        public List<Integer> majorityElement(int[] nums) {
            List<Integer> res = new ArrayList<>();
            if (nums == null || nums.length == 0) return res;

            int[] m = new int[3];
            int[] c = new int[3];
            for (int i=0; i<nums.length; i++) {
                insertOrDelete(m, c, nums[i]);
            }
            for (int i=0; i<3; i++) {
                if (c[i] > 0) {
                    int count = 0;
                    for (int j: nums) {
                        if (m[i] == j) count++;
                    }
                    if (count > nums.length/3) res.add(m[i]);
                }
            }
            return res;
        }

        private int insertOrDelete(int[] m, int[] c, int num) {
            for (int i=0; i<m.length; i++) {
                if (m[i] == num && c[i] > 0) {
                    c[i]++;
                    return i;
                }
            }
            for (int i=0; i<m.length; i++) {
                if (c[i] == 0) {
                    m[i] = num;
                    c[i]++;
                    break;
                }
            }
            if (c[0]>0 && c[1]>0 && c[2]>0) {
                c[0]--; c[1]--; c[2]--;
            }
            return -1;
        }
    }
    public static class UnitTest {
        @Test
        public void testMajorityElementII() {
            Solution s = new MajorityElementII().new Solution();
        }
    }
}

