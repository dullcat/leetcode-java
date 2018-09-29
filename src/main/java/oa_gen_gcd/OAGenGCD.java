package oa_gen_gcd;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class OAGenGCD {

    // Insert your Solution class here
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
    class GCD
    {
        // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
        public int generalizedGCD(int num, int[] arr)
        {
            // WRITE YOUR CODE HERE
            if (arr == null || arr.length == 0) {
                return 0;
            }
            int res = arr[0];
            for (int i=1; i<arr.length; i++) {
                res = gcd(res, arr[i]);
            }
            return res;
        }

        private int gcd(int a, int b) {
            if (b == 0) return a;
            if (a < b) {
                return gcd(b, a);
            }
            return gcd(b, a % b);
        }
        // METHOD SIGNATURE ENDS
    }
    public static class UnitTest {
        @Test
        public void testOAGenGCD() {
            //Solution s = new OAGenGCD().new Solution();

        }
    }
}

