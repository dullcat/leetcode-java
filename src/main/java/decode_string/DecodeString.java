package decode_string;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class DecodeString {
//    Given an encoded string, return it's decoded string.
//
//    The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
//
//    You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
//
//            Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
//
//    Examples:
//
//    s = "3[a]2[bc]", return "aaabcbc".
//    s = "3[a2[c]]", return "accaccacc".
//    s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

    // Insert your Solution class here
    class Solution {
        public String decodeString(String s) {
            StringBuilder curS = new StringBuilder();
            int curNum = 0;
            Stack<Integer> stack = new Stack<>();
            Stack<String> stackS = new Stack<>();
            int i = 0;
            for (i = 0; i<s.length(); i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    curNum = curNum * 10 + c-'0';
                }
                else if (c == '[') {
                    stack.push(curNum);
                    stackS.push(curS.toString());
                    curNum = 0;
                    curS = new StringBuilder();
                }
                else if (c == ']') {
                    StringBuilder temp = new StringBuilder();
                    int num = stack.pop();
                    String pre = stackS.pop();
                    temp.append(pre);
                    while (num > 0) {
                        temp.append(curS.toString());
                        num--;
                    }
                    curS = temp;
                }
                else {
                    curS.append(c);
                }
            }
            return curS.toString();
        }
    }
    public static class UnitTest {
        @Test
        public void testDecodeString() {
            Solution s = new DecodeString().new Solution();
        }
    }
}

