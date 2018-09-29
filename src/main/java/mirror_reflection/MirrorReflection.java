package mirror_reflection;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MirrorReflection {
//    There is a special square room with mirrors on each of the four walls.  Except for the southwest corner, there are receptors on each of the remaining corners, numbered 0, 1, and 2.
//
//    The square room has walls of length p, and a laser ray from the southwest corner first meets the east wall at a distance q from the 0th receptor.
//
//    Return the number of the receptor that the ray meets first.  (It is guaranteed that the ray will meet a receptor eventually.)
//
//
//
//    Example 1:
//
//    Input: p = 2, q = 1
//    Output: 2
//    Explanation: The ray meets receptor 2 the first time it gets reflected back to the left wall.
//
//
//
//            Note:
//
//            1 <= p <= 1000
//            0 <= q <= p

    // Insert your Solution class here
    class Solution {
        public int mirrorReflection(int p, int q) {
            if (q == 0) return 0;
            if (q == p) return 1;
            int gcd = gcd(p, q);
            int x = p / gcd - 1;
            int y = q / gcd - 1;
            if ((x & 1) == 0 && (y & 1) == 0) return 1;
            if ((x & 1) == 1 && (y & 1) == 0) return 2;
            if ((x & 1) == 0 && (y & 1) == 1) return 0;
            return 3;
        }

        private int gcd(int p, int q) {
            if (q == 0) return p;
            return gcd(q, p % q);
        }
    }
    public static class UnitTest {
        @Test
        public void testMirrorReflection() {
            Solution s = new MirrorReflection().new Solution();
        }
    }
}

