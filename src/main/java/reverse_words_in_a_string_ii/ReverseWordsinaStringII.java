package reverse_words_in_a_string_ii;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ReverseWordsinaStringII {
//    Given an input string , reverse the string word by word.
//
//            Example:
//
//    Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
//    Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
//    Note:
//
//    A word is defined as a sequence of non-space characters.
//    The input string does not contain leading or trailing spaces.
//    The words are always separated by a single space.
//    Follow up: Could you do it in-place without allocating extra space?

    // Insert your Solution class here
    class Solution {
        public void reverseWords(char[] str) {
            if (str == null || str.length <= 1) return;
            int fast = 0, slow = 0, n = str.length;
            while (fast < n) {
                while (fast<n && str[fast] != ' ') fast++;
                reverseWord(str, slow, fast-1);
                if (fast < n) {
                    fast++;
                    slow = fast;
                }
            }
            reverseWord(str, 0, n-1);
        }

        private void reverseWord(char[] str, int s, int t) {
            while (s < t) {
                char temp = str[s];
                str[s] = str[t];
                str[t] = temp;
                s++;
                t--;
            }
        }
    }
    public static class UnitTest {
        @Test
        public void testReverseWordsinaStringII() {
            Solution s = new ReverseWordsinaStringII().new Solution();
        }
    }
}

