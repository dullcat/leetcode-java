package consistent_hashing;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ConsistentHashing {
//    Description
//    一般的数据库进行horizontal shard的方法是指，把 id 对 数据库服务器总数 n 取模，然后来得到他在哪台机器上。这种方法的缺点是，当数据继续增加，我们需要增加数据库服务器，将 n 变为 n+1 时，几乎所有的数据都要移动，这就造成了不 consistent。为了减少这种 naive 的 hash方法(%n) 带来的缺陷，出现了一种新的hash算法：一致性哈希的算法——Consistent Hashing。这种算法有很多种实现方式，这里我们来实现一种简单的 Consistent Hashing。
//
//    将 id 对 360 取模，假如一开始有3台机器，那么让3台机器分别负责0~119, 120~239, 240~359 的三个部分。那么模出来是多少，查一下在哪个区间，就去哪台机器。
//    当机器从 n 台变为 n+1 台了以后，我们从n个区间中，找到最大的一个区间，然后一分为二，把一半给第n+1台机器。
//    比如从3台变4台的时候，我们找到了第3个区间0~119是当前最大的一个区间，那么我们把0~119分为0~59和60~119两个部分。0~59仍然给第1台机器，60~119给第4台机器。
//    然后接着从4台变5台，我们找到最大的区间是第3个区间120~239，一分为二之后，变为 120~179, 180~239。
//    假设一开始所有的数据都在一台机器上，请问加到第 n 台机器的时候，区间的分布情况和对应的机器编号分别是多少？
//
//    你可以假设 n <= 360. 同时我们约定，当最大区间出现多个时，我们拆分编号较小的那台机器。
//    比如0~119， 120~239区间的大小都是120，但是前一台机器的编号是1，后一台机器的编号是2, 所以我们拆分0~119这个区间。
//
//    Clarification
//    If the maximal interval is [x, y], and it belongs to machine id z, when you add a new machine with id n, you should divide [x, y, z] into two intervals:
//
//            [x, (x + y) / 2, z] and [(x + y) / 2 + 1, y, n]
//
//    Example
//    for n = 1, return
//
//            [
//            [0,359,1]
//            ]
//    represent 0~359 belongs to machine 1.
//
//            for n = 2, return
//
//            [
//            [0,179,1],
//            [180,359,2]
//            ]
//            for n = 3, return
//
//            [
//            [0,89,1]
//            [90,179,3],
//            [180,359,2]
//            ]
//            for n = 4, return
//
//            [
//            [0,89,1],
//            [90,179,3],
//            [180,269,2],
//            [270,359,4]
//            ]
//            for n = 5, return
//
//            [
//            [0,44,1],
//            [45,89,5],
//            [90,179,3],
//            [180,269,2],
//            [270,359,4]
//            ]

    // Insert your Solution class here
    public class Solution {
        /*
         * @param n: a positive integer
         * @return: n x 3 matrix
         */
        public List<List<Integer>> consistentHashing(int n) {
            // write your code here
            List<List<Integer>> res = new ArrayList<>();
            if (n == 0) return res;
            List<Integer> first = new ArrayList<>();
            first.add(0);
            first.add(359);
            first.add(1);
            res.add(first);
            int i = 2;
            while (i <= n) {
                int pos = findMaxNode(res);
                List<Integer> cur = res.get(pos);
                List<Integer> next = new ArrayList<Integer>();
                int mid = cur.get(0) + (cur.get(1)-cur.get(0))/2;
                next.add(mid+1);
                next.add(cur.get(1));
                next.add(i);
                cur.set(1, mid);
                res.add(pos+1, next);
                i++;
            }
            return res;
        }

        private int findMaxNode(List<List<Integer>> list) {
            int res = 0;
            int size = (list.get(0).get(1)-list.get(0).get(0) + 1);
            int n = list.get(0).get(2);
            for (int i=1; i<list.size(); i++) {
                if ((list.get(i).get(1)-list.get(i).get(0) + 1) > size ||
                        (list.get(i).get(1)-list.get(i).get(0) + 1) == size && list.get(i).get(2)<n) {
                    size = (list.get(i).get(1)-list.get(i).get(0) + 1);
                    res = i;
                    n = list.get(i).get(2);
                }
            }
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testConsistentHashing() {
            Solution s = new ConsistentHashing().new Solution();
        }
    }
}

