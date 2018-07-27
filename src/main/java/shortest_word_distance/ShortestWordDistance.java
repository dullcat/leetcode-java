package shortest_word_distance;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ShortestWordDistance {
//    Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
//
//    Example:
//    Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
//
//    Input: word1 = “coding”, word2 = “practice”
//    Output: 3
//    Input: word1 = "makes", word2 = "coding"
//    Output: 1
//    Note:
//    You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

    // Insert your Solution class here
    class Solution {
        public int shortestDistance(String[] words, String word1, String word2) {
            int res = Integer.MAX_VALUE;
            int i1 = -1;
            int i2 = -1;
            for (int i=0; i<words.length; i++) {
                if (word1.equals(words[i])) i1 = i;
                if (word2.equals(words[i])) i2 = i;
                if (i1 > -1 && i2 > -1)
                    res = Math.min(res, Math.abs(i1-i2));
            }
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testShortestWordDistance() {
            Solution s = new ShortestWordDistance().new Solution();
        }
    }
}

