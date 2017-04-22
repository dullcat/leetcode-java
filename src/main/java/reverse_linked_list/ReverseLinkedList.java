package reverse_linked_list;

import java.util.*;

import common.ListNode;
import org.junit.*;
import static org.junit.Assert.*;

public class ReverseLinkedList {

    // Insert your Solution class here
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode newHead = null;
            while (head != null) {
                ListNode t = head;
                head = head.next;
                t.next = newHead;
                newHead = t;
            }

            return newHead;
        }
        public ListNode reverseList1(ListNode head) {
            if (head == null) return null;
            ListNode pre = new ListNode(0);
            pre.next = head;
            ListNode cur = pre.next;
            ListNode next = cur.next;

            while (next != null) {
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
                next = cur.next;
            }

            return pre.next;
        }
    }
    public static class UnitTest {
        //@Test
        public void testReverseLinkedList() {
            Solution s = new ReverseLinkedList().new Solution();
            //assertEquals(2.5, 2.4999999, 1E-6);
        }
    }
}

