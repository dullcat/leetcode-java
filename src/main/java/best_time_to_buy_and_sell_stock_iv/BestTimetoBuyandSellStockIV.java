package best_time_to_buy_and_sell_stock_iv;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class BestTimetoBuyandSellStockIV {
//    Say you have an array for which the ith element is the price of a given stock on day i.
//
//    Design an algorithm to find the maximum profit. You may complete at most k transactions.
//
//            Note:
//    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
//
//    Example 1:
//
//    Input: [2,4,1], k = 2
//    Output: 2
//    Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
//    Example 2:
//
//    Input: [3,2,6,5,0,3], k = 2
//    Output: 7
//    Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
//    Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

    // Insert your Solution class here
    class Solution {
        public int maxProfit(int k, int[] prices) {
            if (prices == null || prices.length < 2) return 0;
            int[] local = new int[k+1];//local[j] = max(local[j]+diff, global[j-1]+max(diff, 0))
            int[] global = new int[k+1];//global[j] = max(global[j], local[j])
            for (int i=1; i<prices.length; i++) {
                int diff = prices[i] - prices[i-1];
                for (int j=k; j>=1; j--) {
                    local[j] = Math.max(local[j]+diff, global[j-1]+Math.max(diff, 0));
                    global[j] = Math.max(global[j], local[j]);
                }
            }
            return global[k];
        }
    }
    class Solution1 {
        public int maxProfit(int k, int[] prices) {
            if (prices == null || prices.length < 2) return 0;
            int[][] local = new int[prices.length+1][k+1];//local[i][j] = max(local[i-1][j]+diff, global[i-1][j-1]+max(diff, 0))
            int[][] global = new int[prices.length+1][k+1];//global[i][j] = max(global[i-1][j], local[i][j])
            for (int i=1; i<prices.length; i++) {
                for (int j=1; j<=k; j++) {
                    int diff = prices[i] - prices[i-1];
                    local[i][j] = Math.max(local[i-1][j]+diff, global[i-1][j-1]+Math.max(diff, 0));
                    global[i][j] = Math.max(global[i-1][j], local[i][j]);
                }
            }
            return global[prices.length-1][k];
        }
    }
    public static class UnitTest {
        @Test
        public void testBestTimetoBuyandSellStockIV() {
            Solution s = new BestTimetoBuyandSellStockIV().new Solution();
        }
    }
}

