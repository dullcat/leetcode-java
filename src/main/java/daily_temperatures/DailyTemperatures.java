package daily_temperatures;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class DailyTemperatures {

    // Insert your Solution class here
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] res = new int[temperatures.length];
            Stack<Integer> stack = new Stack<Integer>();
            for (int i=0; i<temperatures.length; i++) {
                while (!stack.isEmpty()) {
                    int top = temperatures[stack.peek()];
                    if (top < temperatures[i]) {
                        int preIdx = stack.pop();
                        res[preIdx] = i - preIdx;
                    }
                    else {
                        break;
                    }
                }
                stack.push(i);
            }

            return res;
        }
    }

    public static class UnitTest {
        @Test
        public void testDailyTemperatures() {
            Solution s = new DailyTemperatures().new Solution();
        }
    }
}

