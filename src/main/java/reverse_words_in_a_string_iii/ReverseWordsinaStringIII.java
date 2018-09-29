package reverse_words_in_a_string_iii;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ReverseWordsinaStringIII {
//    Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
//
//            Example 1:
//    Input: "Let's take LeetCode contest"
//    Output: "s'teL ekat edoCteeL tsetnoc"
//    Note: In the string, each word is separated by single space and there will not be any extra space in the string.
//

    // Insert your Solution class here
    class Solution {
        public String reverseWords(String s) {
            if (s == null || s.isEmpty()) return s;

            char[] chars = s.toCharArray();
            int base = 0;
            int head = 0;
            while (head < s.length()) {
                while (head < s.length() && s.charAt(head) != ' ') {
                    head++;
                }
                reverse(chars, base, head-1);
                while (head < s.length() && s.charAt(head) == ' ') {
                    head++;
                }
                base = head;
            }
            return new String(chars);
        }
        private void reverse(char[] str, int i, int j) {
            while (i < j) {
                char c = str[i];
                str[i++] = str[j];
                str[j--] = c;
            }
        }

    }
    public static class UnitTest {
        @Test
        public void testReverseWordsinaStringIII() {
            Solution s = new ReverseWordsinaStringIII().new Solution();
        }
    }
}

