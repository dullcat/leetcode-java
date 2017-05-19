package divide_two_integers;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class DivideTwoIntegers {

    // Insert your Solution class here
    public class Solution {
        public int divide(int dividend, int divisor) {
            if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
            if (dividend == 0) return 0;
            if (divisor == 1) return dividend;
            long ldividend = (long) dividend;
            long ldivisor = (long) divisor;

            boolean isPositive = (ldivisor > 0 && ldividend > 0) || (ldivisor < 0 && ldividend < 0);
            if (divisor < 0) ldivisor = - ldivisor;
            if (dividend < 0) ldividend = -ldividend;
            long res = 0;
            long multi = 1;
            while (multi >= 1) {
                if (ldivisor == 0) break;
                if (ldividend >= ldivisor) {
                    ldividend -= ldivisor;
                    res += multi;
                    if (ldividend/2 > ldivisor) {
                        multi = multi << 1;
                        ldivisor = ldivisor << 1;
                    }
                }
                else {
                    multi = multi >> 1;
                    ldivisor = ldivisor >> 1;
                }
            }
            return (int)(isPositive? res : -res);
        }
    }
    public static class UnitTest {
        @Test
        public void testDivideTwoIntegers() {
            Solution s = new DivideTwoIntegers().new Solution();
            assertEquals(-1, s.divide(-1, 1));
            assertEquals(-2/3, s.divide(-2, 3));
            assertEquals(-1073741824, s.divide(-2147483648, 2));
            assertEquals(1073741823, s.divide(2147483647, 2));
        }
    }
}

