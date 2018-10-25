package reverse_words_in_a_string;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ReverseWordsinaString {
//    Given an input string, reverse the string word by word.
//
//            Example:
//
//    Input: "the sky is blue",
//    Output: "blue is sky the".
//    Note:
//
//    A word is defined as a sequence of non-space characters.
//    Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
//    You need to reduce multiple spaces between two words to a single space in the reversed string.
//    Follow up: For C programmers, try to solve it in-place in O(1) space.
//

    // Insert your Solution class here
    public class Solution {
        public String reverseWords(String s) {
            if (s == null || s.isEmpty()) return s;

            String[] words = s.trim().split(" ");
            int n = words.length;
            if (n == 0)
                return "";
            StringBuilder res = new StringBuilder(words[n-1]);
            for (int i=n-2; i >= 0; i--) {
                if (!words[i].isEmpty())
                    res.append(' ').append(words[i]);
            }

            return res.toString();
        }
    }
    public static class UnitTest {
        @Test
        public void testReverseWordsinaString() {
            Solution s = new ReverseWordsinaString().new Solution();
            assertEquals(s.reverseWords(" 1"), "1");
        }
    }
}

