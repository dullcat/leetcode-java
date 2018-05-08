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

            for (int i=cur; i<nums.length;) {
                curList.add(nums[i]);
                sub(nums, cur+1, curList, res);
                curList.remove(curList.size()-1);
                while (i+1<nums.length && nums[i]==nums[i+1]) i++;
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

