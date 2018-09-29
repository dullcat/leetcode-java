package gcd;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class GCD {

    // Insert your Solution class here
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
    class Solution
    {
        // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
        public int generalizedGCD(int num, int[] arr)
        {
            // WRITE YOUR CODE HERE
            int n = Math.min(num, arr.length);
            if (n < 2) return -1;
            int res = gcd(arr[0], arr[1]);
            for (int i=2; i<n; i++) {
                res = gcd(res, arr[i]);
            }
            return res;
        }
        private int gcd(int a, int b) {
            if (a < b) {
                int t = a;
                a = b;
                b = t;
            }
            if (a % b == 0) return b;
            return gcd(b, a % b);
        }
        // METHOD SIGNATURE ENDS
    }
    public static class UnitTest {
        @Test
        public void testGCD() {
            Solution s = new GCD().new Solution();
        }
    }
}

