package pown;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class Pown {

    // Insert your Solution class here
    class Solution {
        public double myPow(double x, int n) {
            if (x == 0) {
                return 0;
            }
            double res = 1.0;
            if (n < 0) {
                x = 1/x;
                if (n == Integer.MIN_VALUE) {
                    res = x;
                    n = Integer.MAX_VALUE;
                }
                else n = -n;
            }

            double cur = x;
            while (n > 0) {
                if ((n & 1) == 1) {
                    res = res * cur;
                }
                cur = cur * cur;
                n = n >> 1;
            }
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testPown() {
            Solution s = new Pown().new Solution();
            assertEquals(s.myPow(2.0, -2147483648), 0.0, 0.001);
            assertEquals(s.myPow(-1.0, -2147483648), 1.0, 0.001);
            assertEquals(s.myPow(0.0, 0), 0.0, 0.001);
        }
    }
}

