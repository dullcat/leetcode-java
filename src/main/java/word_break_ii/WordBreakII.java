package word_break_ii;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class WordBreakII {

    // Insert your Solution class here
    public class Solution {
        public boolean wordBreak1(String s, List<String> wordDict) {
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
        public List<String> wordBreak(String s, List<String> wordDict) {
            if (s == null || s.length() == 0) return null;
            if (wordBreak1(s, wordDict) == false) return null;
            HashSet<String> dict = new HashSet<String>(wordDict);
            ArrayList<String> res = new ArrayList<String>();
            ArrayList<String> curList = new ArrayList<String>();
            helper(s, dict, 0, curList, res);
            return res;
        }
        void helper(String s, HashSet<String> wordDict, int start, List<String> curList, List<String> res) {
            if (start == s.length()) {
                StringBuilder str = new StringBuilder();
                str.append(curList.get(0));
                for (int i=1; i<curList.size(); i++) {
                    str.append(" ");
                    str.append(curList.get(i));
                }
                res.add(str.toString());
                return;
            }
            for (int i=start; i<s.length(); i++) {
                String str = s.substring(start, i+1);
                if (wordDict.contains(str)) {
                    List<String> newList = new ArrayList<String>(curList);
                    newList.add(str);
                    helper(s, wordDict, start+str.length(), newList, res);
                }
            }
        }
    }
    public static class UnitTest {
        @Test
        public void testWordBreakII() {
            Solution s = new WordBreakII().new Solution();
        }
    }
}

