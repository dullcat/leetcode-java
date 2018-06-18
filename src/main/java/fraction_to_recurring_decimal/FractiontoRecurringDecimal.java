package fraction_to_recurring_decimal;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class FractiontoRecurringDecimal {

    // Insert your Solution class here
    class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            StringBuilder sb = new StringBuilder();
            sb.append(numerator/denominator);
            if (numerator % denominator == 0) {
                return sb.toString();
            }

            sb.append('.');
            int n = numerator % denominator;
            int d = denominator;
            int lastn = n;
            while (n < d) {
                while (n<d) n = n * 10;
                int res = n / d;
                if (n % d == 0) {
                    sb.append(res);
                    break;
                }
                else if (n % d == lastn) {
                    sb.append('(');
                    sb.append(res);
                    sb.append(')');
                    break;
                }
                else {
                    sb.append(res);
                    n = n % d;
                    lastn = n;
                }
            }
            return sb.toString();
        }
    }
    public static class UnitTest {
        @Test
        public void testFractiontoRecurringDecimal() {
            Solution s = new FractiontoRecurringDecimal().new Solution();
        }
    }
}

