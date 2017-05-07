package interleaving_string;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class InterleavingString {

    // Insert your Solution class here
    public class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1 == null || s2 == null || s3 == null) return true;
            if (s1.length() + s2.length() != s3.length()) return false;
            int len1 = s1.length();
            int len2 = s2.length();
            boolean[][] dp = new boolean[len1+1][len2+1];
            dp[0][0] = true;
            for (int i=1; i<=len1; i++) {
                if (dp[i-1][0] && s1.charAt(i-1)==s3.charAt(i-1)) {
                    dp[i][0] = true;
                }
            }
            for (int i=1; i<=len2; i++) {
                if (dp[0][i-1] && s2.charAt(i-1)==s3.charAt(i-1)) {
                    dp[0][i] = true;
                }
            }
            for (int i=1; i<=len1; i++) {
                for (int j=1; j<=len2; j++) {
                    dp[i][j] = dp[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1)
                            || dp[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1);
                }
            }
            return dp[len1][len2];
        }
    }

    // O(n) space
    public class Solution1 {
        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1 == null || s2 == null || s3 == null) return true;
            if (s1.length() + s2.length() != s3.length()) return false;
            int len1 = s1.length();
            int len2 = s2.length();
            boolean[] dp = new boolean[len1+1];
            dp[0] = true;
            for(int i=1; i<=len1; i++) {
                dp[i] = dp[i-1] && s1.charAt(i-1)==s3.charAt(i-1);
            }
            for (int j=1; j<=len2; j++) {
                dp[0] = dp[0] && s2.charAt(j-1)==s3.charAt(j-1);
                for (int i=1; i<=len1; i++) {
                    dp[i] = dp[i-1] && s1.charAt(i-1)==s3.charAt(i+j-1)
                            || dp[i] && s2.charAt(j-1)==s3.charAt(i+j-1);
                }
            }
            return dp[len1];
        }
    }
    public static class UnitTest {
        @Test
        public void testInterleavingString() {
            Solution s = new InterleavingString().new Solution();
        }
    }
}

