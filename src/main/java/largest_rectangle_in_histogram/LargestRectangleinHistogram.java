package largest_rectangle_in_histogram;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class LargestRectangleinHistogram {

    // Insert your Solution class here
    class Solution {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            int max = 0;

            stack.push(-1);
            for (int i=0; i<=heights.length; i++) {
                int curHeight = i==heights.length? 0: heights[i];
                while (stack.peek()!=-1 && curHeight<heights[stack.peek()]) {
                    int cur = stack.pop();
                    int left = stack.peek();
                    max = Math.max(max, heights[cur]*(i-left-1));
                }
                stack.push(i);
            }

            return max;
        }
    }
    public static class UnitTest {
        @Test
        public void testLargestRectangleinHistogram() {
            Solution s = new LargestRectangleinHistogram().new Solution();
        }
    }
}

