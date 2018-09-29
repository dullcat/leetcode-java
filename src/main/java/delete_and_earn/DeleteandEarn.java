package delete_and_earn;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class DeleteandEarn {
//    Given an array nums of integers, you can perform operations on the array.
//
//    In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.
//
//    You start with 0 points. Return the maximum number of points you can earn by applying such operations.
//
//            Example 1:
//    Input: nums = [3, 4, 2]
//    Output: 6
//    Explanation:
//    Delete 4 to earn 4 points, consequently 3 is also deleted.
//            Then, delete 2 to earn 2 points. 6 total points are earned.
//    Example 2:
//    Input: nums = [2, 2, 3, 3, 3, 4]
//    Output: 9
//    Explanation:
//    Delete 3 to earn 3 points, deleting both 2's and the 4.
//    Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
//    9 total points are earned.
//    Note:
//
//    The length of nums is at most 20000.
//    Each element nums[i] is an integer in the range [1, 10000].

    // Insert your Solution class here
    // DP
    class Solution {
        public int deleteAndEarn(int[] nums) {
            if (nums == null || nums.length == 0) return 0;

            final int N = 10000;
            int[] count = new int[N+1];
            for (int i: nums) {
                count[i]++;
            }

            int i=1, j=1;
            int deleted = 0, kept = 0;
            while (i <= N) {
                if (count[i] == 0) {
                    i++;
                    continue;
                }
                int t = deleted;
                if (i-j == 1) {
                    deleted = kept + count[i] * i;
                }
                else {
                    deleted = Math.max(kept, deleted) + count[i] * i;
                }
                kept = Math.max(kept, t);
                j = i;
                i++;

            }
            return Math.max(deleted, kept);
        }
    }
    // Wrong answer.
    class Solution1 {
        public int deleteAndEarn(int[] nums) {
            final int N = 10;
            if (nums == null || nums.length == 0) return 0;

            int[] count = new int[N+1];
            for (int i: nums) {
                count[i]++;
            }
            for (int i=0; i<=N; i++) if (count[i] > 0) {
                System.out.println(i*count[i]);
            }

            int i=1, j=1;
            int res = 0;
            while (i <= N) {
                while (i<=N && count[i] == 0) i++;
                j = i;
                int s1 = 0, s2 = 0;
                while (i<=N && count[i] > 0) {
                    if (((i-j) & 1) == 0) s1 += count[i] * i;
                    else s2 += count[i] * i;
                    i++;
                }
                System.out.println(s1);
                System.out.println(s2);
                res += Math.max(s1, s2);
            }
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testDeleteandEarn() {
            Solution s = new DeleteandEarn().new Solution();
            assertEquals(89, s.deleteAndEarn(new int[]{10, 8, 4, 2, 1, 3, 4, 8, 2, 9, 10, 4, 8, 5, 9, 1, 5, 1, 6, 8, 1, 1, 6, 7, 8, 9}));
        }
    }
}

