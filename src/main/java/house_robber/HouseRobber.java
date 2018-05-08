package house_robber;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class HouseRobber {

    // Insert your Solution class here
    /*class Solution {
        public int rob(int[] nums) {
            return rec(nums, 0);
        }

        private int rec(int[] nums, int start) {
            if (start >= nums.length) return 0;
            return Math.max(nums[start] +rec(nums, start+2), rec(nums, start+1));
        }
    }

    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int[] dp = new int[nums.length+2];

            for (int i=nums.length-1; i>0; i--) {
                dp[i] = Math.max(dp[i+1], dp[i+2]+nums[i-1]);
            }
            return dp[0];
        }
    }
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int d0=0, d1=0, d2=0;

            for (int i=nums.length-1; i>=0; i--) {
                d0 = Math.max(d1, d2+nums[i]);
                d2=d1;
                d1=d0;
            }
            return d0;
        }
    }*/
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) return 0;

            int d0=0, d1=0, d2=0;

            for (int i=0; i<nums.length; i++) {
                d2 = Math.max(d1, d0+nums[i]);
                d0=d1;
                d1=d2;
            }
            return d2;
        }
    }

    public static class UnitTest {
        @Test
        public void testHouseRobber() {
            Solution s = new HouseRobber().new Solution();
        }
    }
}

