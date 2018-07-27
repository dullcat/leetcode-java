package valid_anagram;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ValidAnagram {
//    Given two strings s and t , write a function to determine if t is an anagram of s.
//
//    Example 1:
//
//    Input: s = "anagram", t = "nagaram"
//    Output: true
//    Example 2:
//
//    Input: s = "rat", t = "car"
//    Output: false
//    Note:
//    You may assume the string contains only lowercase alphabets.
//
//    Follow up:
//    What if the inputs contain unicode characters? How would you adapt your solution to such case?
//

    // Insert your Solution class here
    class Solution {
        public boolean isAnagram(String s, String t) {
            return getKey(s).equals(getKey(t));
        }

        private String getKey(String s) {
            char[] str = s.toCharArray();
            Arrays.sort(str);
            return new String(str);
        }
    }
    public static class UnitTest {
        @Test
        public void testValidAnagram() {
            Solution s = new ValidAnagram().new Solution();
        }
    }
}

