package palindrome_number;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class PalindromeNumber {

    // Insert your Solution class here
    public class Solution {
        public boolean isPalindrome(int x) {
            long rev = 0;
            long xSave = x;
            while (x > 0) {
                rev = rev * 10 + x % 10;
                x = x / 10;
            }
            return rev == xSave;
        }
    }
    public static class UnitTest {
        //@Test
        public void testPalindromeNumber() {
            Solution s = new PalindromeNumber().new Solution();
            //assertEquals(2.5, 2.4999999, 1E-6);
        }
    }
}

