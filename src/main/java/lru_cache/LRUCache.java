package lru_cache;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class LRUCache {

    // Insert your Solution class here
    class LRUCache1 {
        class Node {
            int key, val;
            Node next, pre;
            public Node(int key, int val){
                this.key = key;
                this.val = val;
            }
        }
        private int capacity;
        private Map<Integer, Node> map;
        Node head, tail;
        int count;

        public LRUCache1(int capacity) {
            this.capacity = capacity;
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.pre = head;
            map = new HashMap<Integer, Node>();
            count = 0;
        }

        public int get(int key) {
            Node node;
            if (map.containsKey(key)) {
                node = map.get(key);

                // move out from original place
                node.pre.next = node.next;
                node.next.pre = node.pre;

                // move to head
                Node temp = head.next;
                head.next = node;
                node.next = temp;
                temp.pre = node;
                node.pre = head;
            }
            else
                return -1;

            return node.val;
        }

        public void put(int key, int value) {
            Node node;

            // get node
            if (map.containsKey(key)) {
                node = map.get(key);
                node.val = value;

                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            else {
                if (count == capacity) {
                    Node temp = tail.pre;
                    temp.pre.next = tail;
                    tail.pre = temp.pre;
                    temp.next = null;
                    temp.pre = null;
                    map.remove(temp.key);
                    count--;
                }
                node = new Node(key, value);
                map.put(key, node);
                count++;
            }

            // insert to head
            Node temp = head.next;
            head.next = node;
            node.next = temp;
            temp.pre = node;
            node.pre = head;
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    public static class UnitTest {
        @Test
        public void testLRUCache() {
            //Solution s = new LRUCache().new Solution(5);
        }
    }
}

