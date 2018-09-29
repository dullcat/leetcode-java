package combination_sum;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class CombinationSum {
//    Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
//
//    The same repeated number may be chosen from candidates unlimited number of times.
//
//            Note:
//
//    All numbers (including target) will be positive integers.
//    The solution set must not contain duplicate combinations.
//    Example 1:
//
//    Input: candidates = [2,3,6,7], target = 7,
//    A solution set is:
//            [
//            [7],
//            [2,2,3]
//            ]
//    Example 2:
//
//    Input: candidates = [2,3,5], target = 8,
//    A solution set is:
//            [
//            [2,2,2,2],
//            [2,3,3],
//            [3,5]
//            ]

    // Insert your Solution class here
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(candidates);
            helper(candidates, target, 0, new ArrayList<>(), res);
            return res;
        }

        private void helper(int[] candidates, int target, int curIdx, List<Integer> curList, List<List<Integer>> res) {
            if (target == 0) {
                res.add(curList);
                return;
            }

            if (curIdx >= candidates.length || target < candidates[curIdx]) return;
            int n = candidates[curIdx];

            int i = 0;
            while (target >= n*i) {
                List<Integer> newList = new ArrayList(curList);
                for (int j=0; j<i; j++)
                    newList.add(n);
                helper(candidates, target-n*i, curIdx+1, newList, res);
                i++;
            }
        }
    }
    public static class UnitTest {
        @Test
        public void testCombinationSum() {
            Solution s = new CombinationSum().new Solution();
        }
    }
}

