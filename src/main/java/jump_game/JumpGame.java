package jump_game;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class JumpGame {
//    Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//    Each element in the array represents your maximum jump length at that position.
//
//            Determine if you are able to reach the last index.
//
//    Example 1:
//
//    Input: [2,3,1,1,4]
//    Output: true
//    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
//            Example 2:
//
//    Input: [3,2,1,0,4]
//    Output: false
//    Explanation: You will always arrive at index 3 no matter what. Its maximum
//    jump length is 0, which makes it impossible to reach the last index.
    // Insert your Solution class here
    class Solution {
        public boolean canJump(int[] nums) {
            if (nums == null || nums.length < 2) return true;
            int canReach = nums[0];
            for (int i=0; i<nums.length && i<=canReach; i++) {
                if (nums[i] + i > canReach) {
                    canReach = nums[i] + i;
                    if (canReach >= nums.length-1) return true;
                }
            }

            return canReach >= nums.length-1;
        }
    }
    public static class UnitTest {
        @Test
        public void testJumpGame() {
            Solution s = new JumpGame().new Solution();
        }
    }
}

