package distinct_subsequences;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class DistinctSubsequences {

    // Insert your Solution class here
    public class Solution {
        public int numDistinct(String s, String t) {
            if (s == null || s.length() == 0) return 0;
            if (t == null || t.length() == 0) return 1;
            int sLen = s.length();
            int tLen = t.length();
            int[][] dp = new int[sLen+1][tLen+1];
            dp[0][0] = 1;
            for (int i=1; i<=s.length(); i++) {
                dp[i][0] = 1;
                for(int j=1; j<=t.length(); j++) {
                    dp[i][j] = dp[i-1][j];
                    if (s.charAt(i-1) == t.charAt(j-1)) {
                        dp[i][j] = dp[i][j] + dp[i-1][j-1];
                    }
                }
            }
            return dp[sLen][tLen];
        }
    }
    public static class UnitTest {
        @Test
        public void testDistinctSubsequences() {
            Solution s = new DistinctSubsequences().new Solution();
            assertEquals(3, s.numDistinct("ccc", "c"));
        }
    }
}

