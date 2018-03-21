package amazon_OA_q1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q1 {
    // Amazon Online Accessment Q1
    public class Solution {
        private int solve(int valueToFind) {
            Integer result = null;

            /***
             * your code here
             ***/
            if (valueToFind == 0) return 1;
            int len = 32;
            if (valueToFind > 0) {
                len = 1;
                while (valueToFind > (1 << (len-1))) {
                    len++;
                    if (valueToFind < (1 << len)) break;
                }
            }
            int reverse = 0;
            for (int i=0; i<len; i++) {
                int bit = (1 << (len-1-i)) & valueToFind;
                if (bit != 0) {
                    reverse = reverse | (1 << i);
                }
            }
            return reverse == valueToFind?1:0;
        }
    }


    public static class UnitTest {
        @Test
        public void testQ1() {
            Solution s = new Q1().new Solution();
            assertEquals(1, s.solve(9));
            assertEquals(0, s.solve(4));
        }
    }
}

