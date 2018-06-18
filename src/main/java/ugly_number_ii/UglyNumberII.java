package ugly_number_ii;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class UglyNumberII {

    // Insert your Solution class here
    class Solution {
        public int nthUglyNumber(int n) {
            int res = 0;
            int i = 0;
            while (res < n) {
                if (uglyNumber(++i)) res++;
            }
            return i;
        }
        private boolean uglyNumber(int n) {
            while (n % 2 == 0) n/=2;
            while (n % 3 == 0) n/=3;
            while (n % 5 == 0) n/=5;
            return n==1;
        }
    }
    public static class UnitTest {
        @Test
        public void testUglyNumberII() {
            Solution s = new UglyNumberII().new Solution();
        }
    }
}

