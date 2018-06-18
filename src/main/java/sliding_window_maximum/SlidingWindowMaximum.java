package sliding_window_maximum;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class SlidingWindowMaximum {
//    Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
//
//            Example:
//
//    Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
//    Output: [3,3,5,5,6,7]
//    Explanation:
//
//    Window position                Max
//---------------               -----
//        [1  3  -1] -3  5  3  6  7       3
//        1 [3  -1  -3] 5  3  6  7       3
//        1  3 [-1  -3  5] 3  6  7       5
//        1  3  -1 [-3  5  3] 6  7       5
//        1  3  -1  -3 [5  3  6] 7       6
//        1  3  -1  -3  5 [3  6  7]      7
//    Note:
//    You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
//
//    Follow up:
//    Could you solve it in linear time?
    // Insert your Solution class here
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0 || k > nums.length)
                return new int[0];
            List<Integer> dq = new LinkedList<>();
            int[] res = new int[nums.length-(k-1)];
            List<Integer> r = new ArrayList<Integer>();
            for (int i=0; i<nums.length; i++) {
                while (!dq.isEmpty() && nums[dq.get(dq.size()-1)] < nums[i]) {
                    dq.remove(dq.size()-1);
                }
                dq.add(i);
                if (i>=k-1) {
                    res[i-(k-1)] = nums[dq.get(0)];
                    if (dq.get(0) == i-(k-1)) dq.remove(0);
                }
            }

            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testSlidingWindowMaximum() {
            Solution s = new SlidingWindowMaximum().new Solution();
        }
    }
}

