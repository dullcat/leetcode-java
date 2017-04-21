package reverse_integer;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ReverseInteger {

    // Insert your Solution class here
    public class Solution {
        public int reverse(int x) {
            long res = 0;

            while (x != 0) {
                res = res * 10 + x % 10;
                x = x / 10;
            }

            if (res >= Integer.MAX_VALUE || res <= Integer.MIN_VALUE) {
                return 0;
            }

            return (int) res;
        }
    }
    public static class UnitTest {
        @Test
        public void testReverseInteger() {
            Solution s = new ReverseInteger().new Solution();
            assertEquals(0, s.reverse(-2147483648));
        }
    }
}

