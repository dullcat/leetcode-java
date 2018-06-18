package super_ugly_number;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class SuperUglyNumber {
//    Write a program to find the nth super ugly number.
//
//    Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.
//
//    Note:
//            (1) 1 is a super ugly number for any given primes.
//            (2) The given numbers in primes are in ascending order.
//            (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
//            (4) The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
//

    // Insert your Solution class here
    class Solution {
        class Node {
            int val;
            int prime;
            public Node(int val, int prime) {
                this.val = val;
                this.prime = prime;
            }
        }
        public int nthSuperUglyNumber(int n, int[] primes) {
            PriorityQueue<Node> pq = new PriorityQueue<Node>((a,b) -> a.val-b.val);
            int[] res = new int[n];
            res[0] = 1;
            int i = 1;
            int[] mark = new int[primes.length];

            for (int j=0; j<primes.length; j++) {
                pq.add(new Node(primes[j] * res[mark[j]], j));
            }

            while (i < n) {
                res[i] = pq.peek().val;
                while (!pq.isEmpty() && pq.peek().val == res[i]) {
                    Node t = pq.poll();
                    mark[t.prime]++;
                    pq.add(new Node(primes[t.prime] * res[mark[t.prime]], t.prime));
                }
                i++;
            }
            return res[n-1];
        }
    }
    public static class UnitTest {
        @Test
        public void testSuperUglyNumber() {
            Solution s = new SuperUglyNumber().new Solution();
        }
    }
}

