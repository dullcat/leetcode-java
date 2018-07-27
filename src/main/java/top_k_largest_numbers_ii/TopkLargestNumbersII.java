package top_k_largest_numbers_ii;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TopkLargestNumbersII {
//    Implement a data structure, provide two interfaces:
//
//    add(number). Add a new number in the data structure.
//            topk(). Return the top k largest numbers in this data structure. k is given when we create the data structure.
//    Have you met this question in a real interview?
//    Example
//            s = new Solution(3);
//            >> create a new data structure.
//            s.add(3)
//            s.add(10)
//            s.topk()
//            >> return [10, 3]
//            s.add(1000)
//            s.add(-99)
//            s.topk()
//            >> return [1000, 10, 3]
//            s.add(4)
//            s.topk()
//            >> return [1000, 10, 4]
//            s.add(100)
//            s.topk()
//            >> return [1000, 100, 10]

    // Insert your Solution class here
    public class Solution {
        PriorityQueue<Integer> q;
        int capacity;
        /*
         * @param k: An integer
         */public Solution(int k) {
            // do intialization if necessary
            q = new PriorityQueue<>(k, (a, b) -> a - b);
            capacity = k;
        }

        /*
         * @param num: Number to be added
         * @return: nothing
         */
        public void add(int num) {
            // write your code here
            q.offer(num);
            if (q.size() > capacity) q.poll();
        }

        /*
         * @return: Top k element
         */
        public List<Integer> topk() {
            // write your code here
            List<Integer> res = new ArrayList<>();
            for (Object i: q.toArray()) {
                res.add((int)i);
            }
            Collections.sort(res);
            Collections.reverse(res);
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testTopkLargestNumbersII() {
            //Solution s = new TopkLargestNumbersII().new Solution();
        }
    }
}

