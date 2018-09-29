package others.combinations;

import java.util.*;

public class Combinations {

    public class Solution {

        private void search(int start, int end, int k,
                ArrayDeque<Integer> queue, ArrayList<ArrayList<Integer>> ans) {
            if (k == 0) {
                ans.add(new ArrayList<Integer>(queue));
                return;
            }
            Queue<int[]> q = new LinkedList<>();

            for (int i = start; i <= end - k + 1; i++) {
                queue.offerLast(i);
                search(i + 1, end, k - 1, queue, ans);
                queue.removeLast();
            }
        }

        public ArrayList<ArrayList<Integer>> combine(int n, int k) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
            search(1, n, k, new ArrayDeque<Integer>(), ans);
            return ans;
        }
    }

    public static class UnitTest {

    }
}
