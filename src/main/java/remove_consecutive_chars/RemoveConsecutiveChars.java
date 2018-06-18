package remove_consecutive_chars;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class RemoveConsecutiveChars {

    // Insert your Solution class here
    // "", null, a, ab, aba, aab, abb, aabbb, abc,abbc,
    class Solution {
        String removeConsecutive(String s) {
            if (s == null || s.length() < 2) return s;
            StringBuilder sb = new StringBuilder();
            int cur = 0;
            for (int i = 1; i < s.length(); i++) {
                while (i < s.length() && s.charAt(i) == s.charAt(cur)) i++;
                if (i - cur == 1)
                    sb.append(s.charAt(cur));
                cur = i;
            }
            if (cur < s.length())
                sb.append(s.charAt(cur));
            return sb.toString();
        }
    }
    public static class UnitTest {
        @Test
        public void testRemoveConsecutiveChars() {
            Solution s = new RemoveConsecutiveChars().new Solution();
        }
    }
}

