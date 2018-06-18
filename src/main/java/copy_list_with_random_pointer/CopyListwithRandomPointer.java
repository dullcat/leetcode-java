package copy_list_with_random_pointer;

import java.util.*;

import common.RandomListNode;
import org.junit.*;
import static org.junit.Assert.*;

public class CopyListwithRandomPointer {

    // Insert your Solution class here
    /**
     * Definition for singly-linked list with a random pointer.
     * class RandomListNode {
     *     int label;
     *     RandomListNode next, random;
     *     RandomListNode(int x) { this.label = x; }
     * };
     */
    public class Solution {
        public RandomListNode copyRandomList(RandomListNode head) {
            if (head == null) return null;
            HashMap<Integer, RandomListNode> map = new HashMap();
            RandomListNode res = new RandomListNode(0);
            RandomListNode cur = res;
            RandomListNode orig = head;
            while (head != null) {
                cur.next = new RandomListNode(head.label);
                map.put(head.label, cur.next);
                head = head.next;
                cur = cur.next;
            }
            cur = res;
            head = orig;
            while (head != null) {
                if (head.random != null)
                    cur.next.random = map.get(head.random.label);
                head = head.next;
                cur = cur.next;
            }
            return res.next;
        }
    }
    public static class UnitTest {
        @Test
        public void testCopyListwithRandomPointer() {
            Solution s = new CopyListwithRandomPointer().new Solution();
        }
    }
}

