package smallest_range;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class SmallestRange {
//    You have k lists of sorted integers in ascending order. Find the smallest range that includes at least one number from each of the k lists.
//
//    We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.
//
//            Example 1:
//    Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
//    Output: [20,24]
//    Explanation:
//    List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
//    List 2: [0, 9, 12, 20], 20 is in range [20,24].
//    List 3: [5, 18, 22, 30], 22 is in range [20,24].
//
//    Note:
//        The given list may contain duplicates, so ascending order means >= here.
//        1 <= k <= 3500
//        -10^5 <= value of elements <= 10^5.
//        For Java users, please note that the input type has been changed to List<List<Integer>>. And after you reset the code template, you'll see this point.

    // Insert your Solution class here
    // after optimization of getRange()
    class Solution {
        public int[] smallestRange(List<List<Integer>> nums) {
            int[] res = new int[2];
            if (nums.size() == 1) {
                res[0] = res[1] = nums.get(0).get(0);
                return res;
            }
            PriorityQueue<List<Integer>> pq = new PriorityQueue<>(nums.size(), new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {
                    return o1.get(0)-o2.get(0);
                }
            });

            int max = -100000;
            for (List<Integer> list: nums) {
                pq.offer(list);
                max = Math.max(max, list.get(0));
            }
            res[0] = pq.peek().get(0);
            res[1] = max;

            while (pq.size() == nums.size()) {
                getRange(pq, res, max);
                List list = pq.poll();
                if (list.size() > 1) {
                    list.remove(0);
                    pq.offer(list);
                    max = Math.max(max, (int)list.get(0));
                }
            }

            return res;
        }
        private void getRange(PriorityQueue<List<Integer>> q, int[] range, int max) {
            int min = q.peek().get(0);
            if (max-min < range[1]-range[0]) {
                range[0] = min;
                range[1] = max;
            }
        }
    }

    // before optimization
    class Solution1 {
        public int[] smallestRange(List<List<Integer>> nums) {
            int[] res = new int[2];
            if (nums.size() == 1) {
                res[0] = res[1] = nums.get(0).get(0);
                return res;
            }
            PriorityQueue<List<Integer>> pq = new PriorityQueue<>(nums.size(), new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {
                    return o1.get(0)-o2.get(0);
                }
            });

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (List<Integer> list: nums) {
                //list.add(Integer.MAX_VALUE);
                pq.offer(list);
            }
            res[0] = min;
            res[1] = max;

            while (pq.size() == nums.size()) {
                getRange(pq, res);
                List list = pq.poll();
                if (list.size() > 1) {
                    list.remove(0);
                    pq.offer(list);
                    max = Math.max(max, (int)list.get(0));
                }
            }

            return res;
        }
        private void getRange(PriorityQueue<List<Integer>> q, int[] range) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for ( Object list: q.toArray()) {
                max = Math.max(max, ((List<Integer>) list).get(0));
                min = Math.min(min, ((List<Integer>) list).get(0));
            }
            if (max-min < range[1]-range[0]) {
                range[0] = min;
                range[1] = max;
            }
        }
    }
    public static class UnitTest {
        @Test
        public void testSmallestRange() {
            Solution s = new SmallestRange().new Solution();
        }
    }
}

