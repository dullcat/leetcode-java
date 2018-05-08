package remove_nth_node_from_end_of_list;

import java.util.*;

import common.ListNode;
import org.junit.*;
import static org.junit.Assert.*;

public class RemoveNthNodeFromEndofList {

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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null) return null;
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode fast = dummy, slow = dummy;

            while (n>0) {
                fast = fast.next;
                n--;
            }
            if (n > 0) return null;

            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }

            slow.next = slow.next.next;
            return dummy.next;
        }
    }
    public static class UnitTest {
        @Test
        public void testRemoveNthNodeFromEndofList() {
            Solution s = new RemoveNthNodeFromEndofList().new Solution();
        }
    }
}

