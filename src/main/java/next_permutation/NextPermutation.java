package next_permutation;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class NextPermutation {

    // Insert your Solution class here
    public class Solution {
        public void nextPermutation(int[] nums) {
            if (nums.length <= 1) return;
            int i = nums.length-1;
            for(; i>0; i--) {
                if (nums[i-1] < nums[i]) {
                    break;
                }
            }
            if (i>0) {
                int j = nums.length - 1;
                for (; j > i-1; j--) {
                    if (nums[j] > nums[i-1]) {
                        swap(nums, i-1, j);
                        break;
                    }
                }
            }

            reverse(nums, i, nums.length-1);
        }
        void reverse(int[] nums, int i, int j) {
            while (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }

    public static class UnitTest {
        @Test
        public void testNextPermutation() {
            Solution s = new NextPermutation().new Solution();
        }
    }
}

