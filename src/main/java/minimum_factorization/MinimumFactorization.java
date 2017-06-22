package minimum_factorization;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MinimumFactorization {

    // Insert your Solution class here
    public class Solution {
        public int smallestFactorization(int a) {
            if (a <= 0) return 0;

            Stack<Integer> factors = new Stack<Integer>();
            while (a >= 10) {
                int t = a;
                for (int i=9; i>=2; i--) {
                    if (a % i == 0) {
                        factors.push(i);
                        a /= i;
                        break;
                    }
                }
                if (a == t) break;
            }
            if (a > 9) return 0;
            long res = a;
            while (!factors.isEmpty()) {
                res = res * 10 + factors.pop();
            }

            if (res > Integer.MAX_VALUE) return 0;
            return (int)res;
        }
    }

    // no stack
    public class Solution1 {
        public int smallestFactorization(int a) {
            if (a <= 0) return 0;

            long res = 0;
            long tens = 1;
            while (a >= 10) {
                int t = a;
                for (int i=9; i>=2; i--) {
                    if (a % i == 0) {
                        a /= i;
                        res = res + tens * i;
                        tens *= 10;
                        break;
                    }
                }
                if (a == t) return 0;
            }

            res += tens * a;
            if (res > Integer.MAX_VALUE) return 0;
            return (int)res;
        }
    }

    // switch loops
    public class Solution2 {
        public int smallestFactorization(int a) {
            if (a <= 0) return 0;

            long res = 0;
            long tens = 1;
            for (int i=9; i>=2; i--) {
                while (a % i == 0) {
                    a /= i;
                    res = res + tens * i;
                    tens *= 10;
                }
            }

            if (a > 9) return 0;
            if (res > Integer.MAX_VALUE) return 0;
            return (int)res;
        }
    }
    public static class UnitTest {
        @Test
        public void testMinimumFactorization() {
            Solution2 s = new MinimumFactorization().new Solution2();
            Assert.assertEquals(68, s.smallestFactorization(48));
            Assert.assertEquals(35, s.smallestFactorization(15));
        }
    }
}

