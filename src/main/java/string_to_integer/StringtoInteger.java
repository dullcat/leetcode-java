package string_to_integer;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StringtoInteger {

    // Insert your Solution class here
    public class Solution {
        public int myAtoi(String str) {
            if (str == null || str.length() == 0) return 0;

            long res = 0;
            boolean isPositive = true;
            int i = 0;

            while (i<str.length() && str.charAt(i) == ' ') {
                i++;
            }
            if (i == str.length()) return 0;

            if (str.charAt(i) == '+') i++;
            else if (str.charAt(i) == '-'){
                isPositive = false;
                i++;
            }

            boolean hasNumber = false;
            while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                hasNumber = true;
                res = res * 10 + str.charAt(i) - '0';
                if (res > Integer.MAX_VALUE) {
                    return isPositive? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                i++;
            }

            if (hasNumber == false) return 0;

            return isPositive? (int)res : -(int)res;
        }
    }
    public static class UnitTest {
        @Test
        public void testStringtoInteger() {
            Solution s = new StringtoInteger().new Solution();
            assertEquals(2147483647, s.myAtoi("2147483648"));
        }
    }
}

