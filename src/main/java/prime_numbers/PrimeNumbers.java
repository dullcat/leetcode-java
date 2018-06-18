package prime_numbers;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class PrimeNumbers {

    // Insert your Solution class here
    public class Solution {
        public ArrayList<Integer> sieve(int A) {
            int[] N = new int[A+1];
            ArrayList<Integer> res = new ArrayList<Integer>();

            if (A < 2) return res;

            int i = 2;
            for (; i<=A; i++) {
                if (N[i] == 0) {
                    res.add(i);
                    for (int j=i+i; j<=A; j+=i) {
                        N[j] = 1;
                    }
                }
            }
            return res;
        }
    }

    public static class UnitTest {
        @Test
        public void testPrimeNumbers() {
            Solution s = new PrimeNumbers().new Solution();
        }
    }
}

