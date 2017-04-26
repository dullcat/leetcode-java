package longest_common_prefix;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class LongestCommonPrefix {

    // Insert your Solution class here
    public class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) return "";
            if (strs.length == 1) return strs[0];
            int maxLen = strs[0].length();
            for (int i=1; i<strs.length; i++) {
                int len = lenCommonStrs(strs[0], strs[i], maxLen);
                if (len == 0) return "";
                maxLen = Math.min(maxLen, len);
            }

            return strs[0].substring(0, maxLen);
        }

        int lenCommonStrs(String s1, String s2, int maxLen) {
            int i;
            for (i = 0; i< maxLen && i < Math.min(s1.length(), s2.length()); i++) {
                if (s1.charAt(i) != s2.charAt(i)) break;
            }
            return i;
        }
    }
    public static class UnitTest {
        @Test
        public void testLongestCommonPrefix() {
            Solution s = new LongestCommonPrefix().new Solution();
            String[] strs = {"a","b"};
            assertEquals(s.longestCommonPrefix(strs), "");
        }
    }
}

