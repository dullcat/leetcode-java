package word_break;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class WordBreak {

    // Insert your Solution class here
    public class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            if (s == null || s.length() == 0) return true;

            boolean dp[] = new boolean[s.length()+1];
            dp[0] = true;

            HashSet<String> dict = new HashSet<String>(wordDict);
            //ith char, from index 1
            for (int i=1; i<=s.length(); i++) {
                for (int j=0; j<i; j++) {
                    if (dp[j] && dict.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }
    public static class UnitTest {
        @Test
        public void testWordBreak() {
            Solution s = new WordBreak().new Solution();
        }
    }
}

