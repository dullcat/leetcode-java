package house_robber_ii;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class HouseRobberII {

    // Insert your Solution class here
    class Solution {
        private int robsub(int[] nums, int s, int e) {
            int d0=0, d1=0, d2=0;
            for (int i=s; i<=e; i++) {
                d2 = Math.max(d1, d0+nums[i]);
                d0 = d1;
                d1 = d2;
            }
            return d2;
        }
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];
            return Math.max(robsub(nums, 0, nums.length-2), robsub(nums, 1, nums.length-1));
        }
    }

    public static class UnitTest {
        @Test
        public void testHouseRobberII() {
            Solution s = new HouseRobberII().new Solution();
        }
    }
}

