package power_of_three;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class PowerofThree {

    // Insert your Solution class here
    class Solution {
        public boolean isPowerOfThree(int n) {
            if (n <= 2) return false;

            while (n > 0) {
                if (n == 1) return true;
                if ((n % 3) != 0) return false;
                n = n/3;
            }

            return true;
        }
    }
    public static class UnitTest {
        @Test
        public void testPowerofThree() {
            Solution s = new PowerofThree().new Solution();
            assertEquals(s.isPowerOfThree(3), true);
        }
    }
}

