package fibonacci_ii;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class FibonacciII {

    // Insert your Solution class here
    public class Solution {
        /**
         * @param n: an integer
         * @return: return a string
         */
        public String lastFourDigitsOfFn(int n) {
            // write your code here
            int[] res = {1,0,0,1};
            int[] cur = {1,1,1,0};
            int i=0;
            while (n > 0) {
                if ((n & 1)==1) {
                    res = multiplyMatrix(res, cur);
                }
                cur = multiplyMatrix(cur, cur);
                n >>>= 1;
            }

            return new Integer(res[2]).toString();
        }

        private int[] multiplyMatrix(int[] a, int[] b) {
            int[] res = new int[4];
            res[0] = (a[0]*b[0] + a[1]*b[2]) % 10000;
            res[1] = (a[0]*b[1] + a[1]*b[3]) % 10000;
            res[2] = (a[2]*b[0] + a[3]*b[2]) % 10000;
            res[3] = (a[2]*b[1] + a[3]*b[3]) % 10000;
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testFibonacciII() {
            Solution s = new FibonacciII().new Solution();
        }
    }
}

