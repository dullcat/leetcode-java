package lru_cache;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class LRUCache {

    // Insert your Solution class here
    private class Node {
        Node next;
        Node pre;
        int val;
    }
    public class Solution {
        int max;
        HashMap<Integer, Integer> map;
        LinkedList<Integer> list;

        public Solution(int capacity) {
            max = capacity;
            map = new HashMap<Integer, Integer>(max);
            list = new LinkedList<Integer>();
        }

        public int get(int key) {
            return 0;
        }

        public void set(int key, int value) {

        }
    }

    public static class UnitTest {
        @Test
        public void testLRUCache() {
            Solution s = new LRUCache().new Solution(5);
        }
    }
}

