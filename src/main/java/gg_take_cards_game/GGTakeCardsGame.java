package gg_take_cards_game;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class GGTakeCardsGame {

    // Insert your Solution class here
    // 1,5,2,7,3,9,4,5,2
    // dp[i]: 从第i个数开始到最后，最多可以取到的最大分数
    // dp[i] = max(sum[i] - dp[i+1], sum[i]-dp[i+2], sum[i]-dp[i+3]);
    class Solution {
        public int getMax(int[] nums) {
            int n = nums.length;
            int[] sums = new int[n+1];
            int[] dp = new int[n+1];
            for (int i=1; i<=n; i++) {
                sums[i] = sums[i-1] + nums[i-1];
            }
            if (n <= 3) return sums[n];

            dp[n] = sums[n] - sums[n-1];
            dp[n-1] = sums[n] - sums[n-2];
            dp[n-2] = sums[n] - sums[n-3];
            for (int i=n-3; i>=0; i--) {
                int sum = sums[n] - sums[i];
                dp[i] = Math.max(Math.max(sum-dp[i+1], sum-dp[i+2]), sum-dp[i+3]);
            }

            return dp[0];
        }
    }
    public static class UnitTest {
        @Test
        public void testGGTakeCardsGame() {
            Solution s = new GGTakeCardsGame().new Solution();
            int[] in1 = {1,2,3};

            // sums= 0, 1, 3, 6, 10
            // dp =  9,7,4
            int[] in2 = {1,2,3,4};
            int[] in3 = {1,2,3,4};
            assertEquals(6, s.getMax(in1));
            assertEquals(9, s.getMax(in2));
        }
    }
}

