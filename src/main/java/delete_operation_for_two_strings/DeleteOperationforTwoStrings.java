package delete_operation_for_two_strings;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class DeleteOperationforTwoStrings {

    /***
     Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.
     */
    // Insert your Solution class here
    public class Solution {
        int findLCS(String w1, String w2) {
            int[][] dp = new int[w1.length()+1][w2.length()+1];
            for (int i=1; i<=w1.length(); i++) {
                for (int j=1; j<=w2.length(); j++) {
                    if (w1.charAt(i-1) == w2.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                    else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
            return dp[w1.length()][w2.length()];
        }
        public int minDistance(String word1, String word2) {
            return word1.length() + word2.length() - 2 * findLCS(word1, word2);
        }
    }
    public static class UnitTest {
        @Test
        public void testDeleteOperationforTwoStrings() {
            Solution s = new DeleteOperationforTwoStrings().new Solution();
        }
    }
}

