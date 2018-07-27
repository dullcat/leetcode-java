package minimum_moves_to_equal_array_elements_ii;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MinimumMovestoEqualArrayElementsII {

    // Insert your Solution class here
    class Solution {
        public int minMoves2(int[] nums) {
            if (nums.length <= 1) return 0;
            Arrays.sort(nums);

            int res = Integer.MAX_VALUE;
            int mid = nums.length/2;
            res = Math.min(moves(nums, nums[mid+1]), moves(nums, nums[mid]));

            return res;
        }

        private int moves(int[] nums, int v) {
            int res = 0;
            for (int i=0; i<nums.length; i++) {
                res += Math.abs(v-nums[i]);
                if (res < 0) return Integer.MAX_VALUE;
            }
            return res;
        }
    }

    // O(n^2)
    class Solution1 {
        public int minMoves2(int[] nums) {
            if (nums.length == 0) return 0;
            int res = Integer.MAX_VALUE;
            for (int i=0; i<nums.length; i++) {
                res = Math.min(res, moves(nums, nums[i]));
            }

            return res;
        }

        private int moves(int[] nums, int v) {
            int res = 0;
            for (int i=0; i<nums.length; i++) {
                res += Math.abs(v-nums[i]);
                if (res < 0) return Integer.MAX_VALUE;
            }
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testMinimumMovestoEqualArrayElementsII() {
            Solution s = new MinimumMovestoEqualArrayElementsII().new Solution();
        }
    }
}

