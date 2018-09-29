package memcache;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class Memcache {
//    Implement a memcache which support the following features:
//
//    get(curtTime, key). Get the key's value, return 2147483647 if key does not exist.
//    set(curtTime, key, value, ttl). Set the key-value pair in memcache with a time to live (ttl). The key will be valid from curtTime to curtTime + ttl - 1 and it will be expired after ttl seconds. if ttl is 0, the key lives forever until out of memory.
//    delete(curtTime, key). Delete the key.
//            incr(curtTime, key, delta). Increase the key's value by delta return the new value. Return 2147483647 if key does not exist.
//    decr(curtTime, key, delta). Decrease the key's value by delta return the new value. Return 2147483647 if key does not exist.
//    It's guaranteed that the input is given with increasingcurtTime.
//
//    Have you met this question in a real interview?
//    Clarification
//    Actually, a real memcache server will evict keys if memory is not sufficient, and it also supports variety of value types like string and integer. In our case, let's make it simple, we can assume that we have enough memory and all of the values are integers.
//
//    Search "LRU" & "LFU" on google to get more information about how memcache evict data.
//
//    Try the following problem to learn LRU cache:
//    http://www.lintcode.com/problem/lru-cache
//
//    Example
//    get(1, 0)
//>> 2147483647
//    set(2, 1, 1, 2)
//    get(3, 1)
//>> 1
//    get(4, 1)
//>> 2147483647
//    incr(5, 1, 1)
//>> 2147483647
//    set(6, 1, 3, 0)
//    incr(7, 1, 1)
//>> 4
//    decr(8, 1, 1)
//>> 3
//    get(9, 1)
//>> 3
//    delete(10, 1)
//    get(11, 1)
//>> 2147483647
//    incr(12, 1, 1)
//>> 2147483647

    // Insert your Solution class here
    public class Memcache1 {
        class Node {
            int time;
            int value;
            int ttl;
        }

        Map<Integer, Node> cache;
        final int INVALID_VALUE = 2147483647;
        public Memcache1() {
            // do intialization if necessary
            cache = new HashMap<>();
        }

        /*
         * @param curtTime: An integer
         * @param key: An integer
         * @return: An integer
         */
        public int get(int curtTime, int key) {
            // write your code here
            if (!cache.containsKey(key)) return INVALID_VALUE;
            Node n = cache.get(key);
            if (n.ttl != 0 && n.time+n.ttl <= curtTime) {
                cache.remove(key);
                return INVALID_VALUE;
            }
            return n.value;
        }

        /*
         * @param curtTime: An integer
         * @param key: An integer
         * @param value: An integer
         * @param ttl: An integer
         * @return: nothing
         */
        public void set(int curtTime, int key, int value, int ttl) {
            // write your code here
            Node n = new Node();
            n.time = curtTime;
            n.value = value;
            n.ttl = ttl;
            cache.put(key, n);
        }

        /*
         * @param curtTime: An integer
         * @param key: An integer
         * @return: nothing
         */
        public void delete(int curtTime, int key) {
            // write your code here
            cache.remove(key);
        }

        /*
         * @param curtTime: An integer
         * @param key: An integer
         * @param delta: An integer
         * @return: An integer
         */
        public int incr(int curtTime, int key, int delta) {
            // write your code here
            if (!cache.containsKey(key)) return INVALID_VALUE;
            Node n = cache.get(key);
            if (n.ttl != 0 && n.time+n.ttl <= curtTime) {
                cache.remove(key);
                return INVALID_VALUE;
            }
            n.value += delta;
            return n.value;
        }

        /*
         * @param curtTime: An integer
         * @param key: An integer
         * @param delta: An integer
         * @return: An integer
         */
        public int decr(int curtTime, int key, int delta) {
            // write your code here
            if (!cache.containsKey(key)) return INVALID_VALUE;
            Node n = cache.get(key);
            if (n.ttl != 0 && n.time+n.ttl <= curtTime) {
                cache.remove(key);
                return INVALID_VALUE;
            }
            n.value -= delta;
            return n.value;
        }
    }
    public static class UnitTest {
        @Test
        public void testMemcache() {
            //Solution s = new Memcache().new Solution();
        }
    }
}

