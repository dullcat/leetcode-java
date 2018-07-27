package top_k_frequent_words_map_reduce;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TopKFrequentWordsMapReduce {
//    Find top k frequent words with map reduce framework.
//
//    The mapper's key is the document id, value is the content of the document, words in a document are split by spaces.
//
//    For reducer, the output should be at most k key-value pairs, which are the top k words and their frequencies in this reducer. The judge will take care about how to merge different reducers' results to get the global top k frequent words, so you don't need to care about that part.
//
//    The k is given in the constructor of TopK class.
//
//    For the words with same frequency, rank them with alphabet.
//
//    Have you met this question in a real interview?
//    Example
//    Given document A =
//
//    lintcode is the best online judge
//    I love lintcode
//    and document B =
//
//    lintcode is an online judge for coding interview
//    you can test your code online at lintcode
//    The top 2 words and their frequencies should be
//
//    lintcode, 4
//    online, 3

    // Insert your Solution class here
    /**
     * Definition of OutputCollector:
     * class OutputCollector<K, V> {
     *     public void collect(K key, V value);
     *         // Adds a key/value pair to the output buffer
     * }
     * Definition of Document:
     * class Document {
     *     public int id;
     *     public String content;
     * }
     */
    class OutputCollector<K, V> {
        public void collect(K key, V value){};
        // Adds a key/value pair to the output buffer
    }
     class Document {
         public int id;
         public String content;
     }
    public static class TopKFrequentWords {

        public static class Map {
            public void map(String _, Document value,
                            OutputCollector<String, Integer> output) {
                // Write your code here
                // Output the results into output buffer.
                // Ps. output.collect(String key, int value);
            }
        }

        public static class Reduce {

            public void setup(int k) {
                // initialize your data structure here
            }

            public void reduce(String key, Iterator<Integer> values) {
                // Write your code here
            }

            public void cleanup(OutputCollector<String, Integer> output) {
                // Output the top k pairs <word, times> into output buffer.
                // Ps. output.collect(String key, Integer value);
            }
        }
    }
    public static class UnitTest {
        @Test
        public void testTopKFrequentWordsMapReduce() {
            //Solution s = new TopKFrequentWordsMapReduce().new Solution();
        }
    }
}

