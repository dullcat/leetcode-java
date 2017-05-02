package best_time_to_buy_and_sell_stock;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class BestTimetoBuyandSellStock {

    // Insert your Solution class here
    public class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length < 2) return 0;
            int[] maxRight = new int[prices.length+1];
            maxRight[prices.length] = prices[prices.length-1];
            for (int i=prices.length-1; i>0; i--) {
                maxRight[i] = Math.max(maxRight[i+1], prices[i]);
            }
            int max = 0;
            for (int i=0; i<prices.length; i++) {
                max = Math.max(max, maxRight[i+1] - prices[i]);
            }

            return max;
        }
    }
    public static class UnitTest {
        @Test
        public void testBestTimetoBuyandSellStock() {
            Solution s = new BestTimetoBuyandSellStock().new Solution();
            assertEquals(5, s.maxProfit(new int[] {1,2,3,6}));
            assertEquals(5, s.maxProfit(new int[] {7,1,5,3,6,4}));
        }
    }
}

