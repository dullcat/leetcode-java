package decompress_string;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class DecompressString {
//    Given a compressed string in which a number followed by [] indicate how many times those characters occur, decompress the string
//    Eg. : a3[b2[c1[d]]]e will be decompressed as abcdcdbcdcdbcdcde.
//    Assume the string is well formed and number will always be followed by a [].

    // Insert your Solution class here
    class Solution {
        public String decompressString(String str) {
            StringBuilder res = new StringBuilder();
            StringBuilder cur = new StringBuilder();
            Stack<StringBuilder> stack = new Stack<>();
            Stack<Integer> stackNum = new Stack<>();
            int curNum = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '[') {
                    stack.push(cur);
                    stackNum.push(curNum);
                    cur = new StringBuilder();
                    curNum = 0;
                }
                else if (str.charAt(i) == ']') {
                    stack.peek().append(timeString(cur.toString(), curNum));
                    cur = stack.pop();
                    curNum = stackNum.pop();
                }
                else if (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                    curNum = curNum * 10 + str.charAt(i) - '0';
                }
                else {
                    cur.append(str.charAt(i));
                }
            }
            return cur.toString();
        }
        private String timeString(String s, int times) {
            StringBuilder res = new StringBuilder();
            while (times > 0) {
                res.append(s);
                times--;
            }
            return res.toString();
        }
    }

    public static class UnitTest {
        @Test
        public void testDecompressString() {
            Solution s = new DecompressString().new Solution();
        }
    }
}

