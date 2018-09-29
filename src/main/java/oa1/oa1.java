package oa1;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class oa1 {

    // Insert your Solution class here
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
    // DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
    public class Solution
    {
        // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
        public List<String> subStringsKDist(String inputStr, int num)
        {
            // WRITE YOUR CODE HERE
            List<String> res = new ArrayList<>();
            Set<String> set = new HashSet<>();
            int[] count = new int[26];
            int distinctChars = 0;
            for (char c: inputStr.toCharArray()) {
                count[c-'a']++;
            }
            for (int i=0; i<26; i++) {
                if (count[i] > 0) distinctChars++;
            }
            if (distinctChars < num) return res;

            int[] map = new int[26];
            int curCount = 0;
            int i = 0;
            int j = 0;
            while (i < inputStr.length()) {
                //System.out.println(i);
                while (curCount < num && i < inputStr.length()) {
                    char c = inputStr.charAt(i++);
                    if (map[c - 'a'] == 0) curCount++;
                    map[c - 'a']++;
                }
                while (i - j > num) {
                    char cj = inputStr.charAt(j++);
                    map[cj - 'a']--;
                    if (map[cj - 'a'] == 0) curCount--;
                }
                if (curCount == num && i-j == num) {
                    //res.add(inputStr.substring(j, i));
                    set.add(inputStr.substring(j, i));
                    //System.out.println(inputStr.substring(j, i));
                    char cj = inputStr.charAt(j++);
                    map[cj - 'a']--;
                    if (map[cj - 'a'] == 0) curCount--;
                }
            }
            for (String s: set) {
                res.add(s);
                System.out.println(s);
            }
            return res;

        }
        // METHOD SIGNATURE ENDS
    }
    public static class UnitTest {
        @Test
        public void testoa1() {
            Solution s = new oa1().new Solution();
            s.subStringsKDist("agawbcccdegawb",4);
        }
    }
}

