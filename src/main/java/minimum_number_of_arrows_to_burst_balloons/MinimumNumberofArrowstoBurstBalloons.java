package minimum_number_of_arrows_to_burst_balloons;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MinimumNumberofArrowstoBurstBalloons {
//    There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.
//
//    An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows that must be shot to burst all balloons.
//
//    Example:
//
//    Input:
//            [[10,16], [2,8], [1,6], [7,12]]
//
//    Output:
//            2
//
//    Explanation:
//    One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).

    // Insert your Solution class here
    class Solution {
        public int findMinArrowShots(int[][] points) {
            int res = 0, left = -1, right = -1;
            Arrays.sort(points, (a,b) -> (a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
            for (int[] p: points) {
                if (p[0]>=left && p[0]<=right || p[1]>=left && p[1]<=right) {
                    left = Math.max(p[0], left);
                    right = Math.min(p[1], right);
                }
                else {
                    res++;
                    left = p[0];
                    right = p[1];
                }
            }
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testMinimumNumberofArrowstoBurstBalloons() {
            Solution s = new MinimumNumberofArrowstoBurstBalloons().new Solution();
        }
    }
}

