package two_sum;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    // Insert your Solution class here
    public class Solution1 {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length <= 1) return null;

            int[] res = new int[2];
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                if (!map.containsKey(target-nums[i])) {
                    map.put(nums[i], i);
                }
                else {
                    res[0] = map.get(target-nums[i]);
                    res[1] = i;
                    return res;
                }
            }
            return res;
        }
    }

    public class Solution {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length <= 1) return null;

            int[] res = new int[2];

            Arrays.sort(nums);

            return res;
        }
    }
    public static class UnitTest {
        
    }
}

