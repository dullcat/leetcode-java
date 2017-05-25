package longest_harmonious_subsequence;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class LongestHarmoniousSubsequence {

    // Insert your Solution class here
    public class Solution {
        public int findLHS(int[] nums) {
            if (nums.length <= 1) return 0;
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i=0; i<nums.length; i++) {
                if (!map.containsKey(nums[i])) {
                    map.put(nums[i], 0);
                }
                map.put(nums[i], map.get(nums[i])+1);
            }
            int res = 0;
            for (int key: map.keySet()) {
                int local = map.get(key);
                if (map.containsKey(key+1)) {
                    local += map.get(key+1);
                    res = Math.max(res, local);
                }
            }
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testLongestHarmoniousSubsequence() {
            Solution s = new LongestHarmoniousSubsequence().new Solution();
            assertEquals(5, s.findLHS(new int[]{1,3,2,2,5,2,3,7}));
            assertEquals(0, s.findLHS(new int[]{1,1,1,1}));
        }
    }
}

