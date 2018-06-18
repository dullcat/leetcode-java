package top_k_frequent_words;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TopKFrequentWords {
//    Given a non-empty list of words, return the k most frequent elements.
//
//    Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
//
//    Example 1:
//    Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//    Output: ["i", "love"]
//    Explanation: "i" and "love" are the two most frequent words.
//    Note that "i" comes before "love" due to a lower alphabetical order.
//    Example 2:
//    Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
//    Output: ["the", "is", "sunny", "day"]
//    Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
//    with the number of occurrence being 4, 3, 2 and 1 respectively.
//            Note:
//    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
//    Input words contain only lowercase letters.
//    Follow up:
//    Try to solve it in O(n log k) time and O(n) extra space.

    // Insert your Solution class here
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> map = new HashMap<>();

            for (String w: words) {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }

            List<String>[] bucket = new List[words.length];
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                if (bucket[e.getValue()] == null) {
                    bucket[e.getValue()] = new ArrayList<>();
                }
                bucket[e.getValue()].add(e.getKey());
            }

            List<String> res = new ArrayList<>();
            for (int i=bucket.length-1; i>=0 && res.size()<k; i--) {
                if (bucket[i] != null) {
                    Collections.sort(bucket[i]);
                    for (String w: bucket[i]) {
                        res.add(w);
                        if (res.size() == k) break;
                    }
                }
            }
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testTopKFrequentWords() {
            Solution s = new TopKFrequentWords().new Solution();
        }
    }
}

