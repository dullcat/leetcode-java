package divide_two_integers;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class DivideTwoIntegers {

    // Insert your Solution class here
    public class Solution {
        public int divide(int dividend, int divisor) {
            if (divisor == 0) return Integer.MAX_VALUE;
            if (dividend == 0) return 0;
            boolean isPositive = (divisor > 0 && dividend > 0) || (divisor < 0 && dividend < 0);
            long longDivisor = divisor, longDividend = dividend;
            if (divisor < 0) longDivisor = - divisor;
            if (dividend < 0) longDividend = -dividend;
            int res = 0;
            int multi = 1;
            while (multi >= 1) {
                if (longDividend >= longDivisor) {
                    longDividend -= longDivisor;
                    res += multi;
                    multi = multi << 1;
                    longDivisor = longDivisor << 1;
                }
                else {
                    multi = multi >> 1;
                    longDivisor = longDivisor >> 1;
                    if (longDivisor == 0) break;
                }
            }
            return isPositive? res : -res;
        }
    }
    public static class UnitTest {
        @Test
        public void testDivideTwoIntegers() {
            Solution s = new DivideTwoIntegers().new Solution();
            assertEquals(-1, s.divide(-1, 1));
            assertEquals(-2/3, s.divide(-2, 3));
            assertEquals(2147483647, s.divide(-2147483648, -1));
        }
    }
}

