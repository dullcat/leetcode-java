package fb_count_target_number;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class FBCountTargetNumber {

    // sorted array of numbers, find count of target
    // Insert your Solution class here
    class Solution {
        public int count(int[] nums, int target) {
            int low = -1;
            int high = nums.length;

            while (low < high - 1) {
                int mid = low + (high-low)/2;
                if (nums[mid] < target) {
                    low = mid;
                }
                else
                    high = mid;
            }
            if (nums[high] != target) return 0;
            int left = high;
            low = high - 1;
            high = nums.length;
            while (low < high - 1) {
                int mid = low + (high-low)/2;
                if (nums[mid] <= target) {
                    low = mid;
                }
                else
                    high = mid;
            }
            int right = low;List<Integer> a = new ArrayList<>(); List<Integer> b = new ArrayList<>(a);
            return right - left + 1;
        }
    }

    public static class UnitTest {
        @Test
        public void testFBCountTargetNumber() {
            Solution s = new FBCountTargetNumber().new Solution();
            assertEquals(1, s.count(new int[] {1,1,2,3}, 3));
            assertEquals(2, s.count(new int[] {2,3,3}, 3));
            assertEquals(2, s.count(new int[] {1,1,2,3}, 1));
            assertEquals(3, s.count(new int[] {1,1,2,2,2,3}, 2));
        }
    }
}

