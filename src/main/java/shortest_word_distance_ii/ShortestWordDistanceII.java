package shortest_word_distance_ii;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ShortestWordDistanceII {
//    Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list. Your method will be called repeatedly many times with different parameters.
//
//            Example:
//    Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
//
//    Input: word1 = “coding”, word2 = “practice”
//    Output: 3
//    Input: word1 = "makes", word2 = "coding"
//    Output: 1
//    Note:
//    You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.


    // Insert your Solution class here
    class WordDistance {
        Map<String, List<Integer>> map = new HashMap();

        public WordDistance(String[] words) {
            for (int i=0; i<words.length; i++) {
                if (!map.containsKey(words[i])) {
                    map.put(words[i], new LinkedList<Integer>());
                }
                map.get(words[i]).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> list1 = map.get(word1);
            List<Integer> list2 = map.get(word2);
            int i1 = 0;
            int i2 = 0;
            int res = Integer.MAX_VALUE;
            while (i1<list1.size() && i2<list2.size()) {
                res = Math.min(res, Math.abs(list1.get(i1)-list2.get(i2)));
                if (list1.get(i1) < list2.get(i2)) i1++;
                else i2++;
            }
            return res;
        }
    }

    /**
     * Your WordDistance object will be instantiated and called as such:
     * WordDistance obj = new WordDistance(words);
     * int param_1 = obj.shortest(word1,word2);
     */
    public static class UnitTest {
        @Test
        public void testShortestWordDistanceII() {
            //Solution s = new ShortestWordDistanceII().new Solution();
        }
    }
}

