package jump_game_ii;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class JumpGameII {
//    Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//    Each element in the array represents your maximum jump length at that position.
//
//    Your goal is to reach the last index in the minimum number of jumps.
//
//    Example:
//
//    Input: [2,3,1,1,4]             [7,0,9,6,9,6,1,7,9,0,1,2,9,0,3]
//    Output: 2
//    Explanation: The minimum number of jumps to reach the last index is 2.
//    Jump 1 step from index 0 to 1, then 3 steps to the last index.
//            Note:
//
//    You can assume that you can always reach the last index.
    // Insert your Solution class here
class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int jumps = 0;
        int curReach = 0;
        int lastReach = 0;

        for (int i=0; i<nums.length; i++) {
            if (i > lastReach) {
                lastReach = curReach;
                jumps++;
            }
            if (i + nums[i] > curReach) {
                curReach = i + nums[i];
            }
        }

        if (curReach >= nums.length-1) return jumps;
        return jumps;
    }
}
    public static class UnitTest {
        @Test
        public void testJumpGameII() {
            Solution s = new JumpGameII().new Solution();
        }
    }
}

