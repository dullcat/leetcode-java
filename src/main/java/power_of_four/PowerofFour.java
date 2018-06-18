package power_of_four;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class PowerofFour {

    // Insert your Solution class here
    class Solution {
        public boolean isPowerOfFour(int num) {
            if (num < 1) return false;
            while (num > 0) {
                if (num == 1) return true;
                if ((num&3) > 0) return false;
                num = num >> 2;
            }

            return false;
        }
    }
    class Solution1 {
        public boolean isPowerOfFour(int num) {
            if (num < 1) return false;
            while (num > 0) {
                if (num == 1) return true;
                if ((num&1) == 1) return false;
                num = num >> 1;
                if ((num&1) == 1) return false;
                num = num >> 1;
            }

            return false;
        }
    }

    public static class UnitTest {
        @Test
        public void testPowerofFour() {
            Solution s = new PowerofFour().new Solution();
        }
    }
}

