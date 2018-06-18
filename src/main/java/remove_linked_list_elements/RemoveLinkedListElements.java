package remove_linked_list_elements;

import java.util.*;

import common.ListNode;
import org.junit.*;
import static org.junit.Assert.*;

public class RemoveLinkedListElements {

    // Insert your Solution class here
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode pre = new ListNode(0);
            ListNode res = pre;
            pre.next = head;
            while (head != null) {
                if (head.val == val) {
                    pre.next = head.next;
                    head.next = null;
                    head = pre.next;
                }
                else {
                    pre = head;
                    head = head.next;
                }
            }
            return res.next;
        }
    }
    public static class UnitTest {
        @Test
        public void testRemoveLinkedListElements() {
            Solution s = new RemoveLinkedListElements().new Solution();
        }
    }
}

