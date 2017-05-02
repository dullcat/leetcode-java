package valid_parentheses;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ValidParentheses {

    // Insert your Solution class here
    public class Solution {
        public boolean isValid(String s) {
            if (s == null || s.length() == 0) return true;
            Stack<Character> stack = new Stack<Character>();
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                    stack.push(s.charAt(i));
                else {
                    if (stack.isEmpty()) return false;
                    char top = stack.pop();
                    if (s.charAt(i) == ')' && top != '(') return false;
                    if (s.charAt(i) == ']' && top != '[') return false;
                    if (s.charAt(i) == '}' && top != '{') return false;
                }
            }
            return stack.isEmpty();
        }
    }
    public static class UnitTest {
        @Test
        public void testValidParentheses() {
            Solution s = new ValidParentheses().new Solution();
        }
    }
}

