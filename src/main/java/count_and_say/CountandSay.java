package count_and_say;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class CountandSay {

    // Insert your Solution class here
    public class Solution {
        public String countAndSay(int n) {
            Queue<Character> curStr = new ArrayDeque<Character>();
            curStr.offer('1');
            Queue<Character> nextStr = new ArrayDeque<Character>();
            while (n > 1) {
                while (!curStr.isEmpty()) {
                    Character curChar = curStr.poll();
                    int curCount = 1;
                    while (!curStr.isEmpty() && curStr.peek() == curChar) {
                        curStr.poll();
                        curCount++;
                    }
                    nextStr.offer(Character.forDigit(curCount, 10));
                    nextStr.offer(curChar);
                }
                Queue<Character> temp = curStr;
                curStr = nextStr;
                nextStr = temp;
                nextStr.clear();
                n--;
            }

            StringBuilder sb = new StringBuilder();
            while (!curStr.isEmpty()) {
                sb.append(curStr.poll());
            }

            return sb.toString();
        }
    }

    // no queue
    public class Solution1 {
        public String countAndSay(int n) {
            String start = "1";
            for(int i=1; i<n; i++){
                start = countAndSayHelper(start);
            }
            return start;
        }

        private String countAndSayHelper(String start) {
            StringBuilder result = new StringBuilder();
            int count = 1;
            int i = 1;
            for(; i<start.length(); i++) {
                if(start.charAt(i) == start.charAt(i-1)) count++;
                else {
                    result.append(count).append(start.charAt(i-1));
                    count = 1;
                }
            }
            result.append(count).append(start.charAt(i-1));
            return result.toString();
        }
    }

    public static class UnitTest {
        @Test
        public void testCountandSay() {
            Solution s = new CountandSay().new Solution();
            Assert.assertEquals("1211", s.countAndSay(4));
        }
    }
}

