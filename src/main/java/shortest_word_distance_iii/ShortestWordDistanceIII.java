package shortest_word_distance_iii;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ShortestWordDistanceIII {
//    Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
//
//    word1 and word2 may be the same and they represent two individual words in the list.
//
//    Example:
//    Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
//
//    Input: word1 = “makes”, word2 = “coding”
//    Output: 1
//    Input: word1 = "makes", word2 = "makes"
//    Output: 3
//    Note:
//    You may assume word1 and word2 are both in the list.


    // Insert your Solution class here
    class Solution {
        public int shortestWordDistance(String[] words, String word1, String word2) {
            int i1 = -1;
            int i2 = -1;
            int res = Integer.MAX_VALUE;
            int sameRes = Integer.MAX_VALUE;

            for (int i=0; i<words.length; i++) {
                if (word1.equals(words[i])) {
                    if (i1 > -1 && word1.equals(word2)) {
                        sameRes = Math.min(sameRes, i-i1);
                    }
                    i1 = i;
                }
                if (word2.equals(words[i])) i2 = i;
                if (!word1.equals(word2) && i1 > -1 && i2 > -1)
                    res = Math.min(res, Math.abs(i1-i2));
            }

            if (word1.equals(word2)) return sameRes;
            else return res;
        }
    }

    // others clean solution
    public class Solution1 {
        public int shortestWordDistance(String[] words, String word1, String word2) {
            int index = -1;
            int min = words.length;
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1) || words[i].equals(word2)) {
                    if (index != -1 && (word1.equals(word2) || !words[index].equals(words[i]))) {
                        min = Math.min(i - index, min);
                    }
                    index = i;
                }
            }
            return min;
        }
    }
    public static class UnitTest {
        @Test
        public void testShortestWordDistanceIII() {
            Solution s = new ShortestWordDistanceIII().new Solution();
        }
    }
}

