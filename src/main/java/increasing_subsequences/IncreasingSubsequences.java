package increasing_subsequences;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class IncreasingSubsequences {

    // Insert your Solution class here
    class Solution {
        public List<List<Integer>> findSubsequences(int[] nums) {
            List curList = new ArrayList<Integer>();
            List res = new ArrayList<ArrayList<Integer>>();
            sub(nums, 0, curList, res);
            return res;
        }

        private void sub(int[] nums, int cur, List<Integer> curList, List<List<Integer>> res) {
            if (curList.size() > 1) {
                res.add(new ArrayList(curList));
            }

            HashMap<Integer, Integer> map = new HashMap();
            for (int i=cur; i<nums.length; i++) {
                if (map.containsKey(nums[i]) ) continue;
                if (curList.size() == 0 || curList.get(curList.size()-1) <= nums[i]) {
                    if (!map.containsKey(nums[i])) map.put(nums[i], curList.size());
                    curList.add(nums[i]);
                    sub(nums, i + 1, curList, res);
                    curList.remove(curList.size() - 1);

                }
            }
        }
    }
    public static class UnitTest {
        @Test
        public void testIncreasingSubsequences() {
            Solution s = new IncreasingSubsequences().new Solution();
        }
    }
}

