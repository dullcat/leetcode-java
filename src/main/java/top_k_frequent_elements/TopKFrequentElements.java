package top_k_frequent_elements;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TopKFrequentElements {
//    Given a non-empty array of integers, return the k most frequent elements.
//
//            For example,
//    Given [1,1,1,2,2,3] and k = 2, return [1,2].
//
//    Note:
//    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
//    Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

    class Node {
        int num;
        int freq;
        Node(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }
    // Insert your Solution class here
    class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap();
            for (int i=0; i<nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    map.put(nums[i], map.get(nums[i])+1);
                }
                else {
                    map.put(nums[i], 1);
                }
            }

            ArrayList<Integer>[] freq = new ArrayList[nums.length+1];
            for (int i: map.keySet()) {
                if (freq[map.get(i)] == null) freq[map.get(i)] = new ArrayList<Integer>();
                freq[map.get(i)].add(i);
            }

            ArrayList<Integer> res = new ArrayList<>();
            for (int i=nums.length; i>=0 && res.size()<k; i--) {
                res.addAll(freq[i]);
            }

            return res.subList(0, k);
        }
    }
    class Solution1 {
        public List<Integer> topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap();
            for (int i=0; i<nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    map.put(nums[i], map.get(nums[i])+1);
                }
                else {
                    map.put(nums[i], 1);
                }
            }

            PriorityQueue<Node> pq = new PriorityQueue<>(map.size(), (a,b) -> b.freq-a.freq);
            for (Integer i: map.keySet()) {
                pq.add(new Node(i, map.get(i)));
            }

            ArrayList<Integer> res = new ArrayList<>();
            while (res.size() < k) {
                res.add(pq.poll().num);
            }

            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testTopKFrequentElements() {
            Solution s = new TopKFrequentElements().new Solution();
        }
    }
}

