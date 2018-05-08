package k_decimal_addition;

import java.lang.reflect.Array;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class KDecimalAddition {

    // Insert your Solution class here
    public class Solution {
        /**
         * @param k: The k
         * @param a: The A
         * @param b: The B
         * @return: The answer
         */
        public String addition(int k, String a, String b) {
            // Write your code here
            if (a == null) return b;
            if (b == null) return a;
            int an = a.length();
            int bn = b.length();
            ArrayList<Integer> res = new ArrayList();

            int c = 0;
            while (an >= 1 || bn >=1 || c>0) {
                int cur = c;
                if (an>=1) {
                    cur += a.charAt(an - 1) - '0';
                    an--;
                }
                if (bn>=1) {
                    cur += b.charAt(bn -1) - '0';
                    bn--;
                }
                res.add(0, cur % k);
                c = cur / k;
            }

            int f = 0;
            while (f < res.size() && res.get(f) == 0) f++;
            if (f == res.size()) return "0";
            StringBuffer sb = new StringBuffer();
            for(int i=f; i<res.size(); i++) {
                sb.append(res.get(i));
            }
            return sb.toString();
        }
    }
    public static class UnitTest {
        @Test
        public void testKDecimalAddition() {
            Solution s = new KDecimalAddition().new Solution();
        }
    }
}

