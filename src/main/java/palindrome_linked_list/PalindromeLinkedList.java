package palindrome_linked_list;

import java.util.*;

import common.ListNode;
import org.junit.*;
import static org.junit.Assert.*;

public class PalindromeLinkedList {

    // Insert your Solution class here
    public class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) return true;
            int len = 0;
            ListNode p = head;

            while (p != null) {
                p = p.next;
                len++;
            }

            if (len == 2) return head.val == head.next.val;
            if (len == 3) return head.val == head.next.next.val;
            ListNode h = head;
            ListNode next = h.next;
            ListNode newHead = null;
            for(int i=0; i<len/2; i++) {
                ListNode t = h;
                h = h.next;
                t.next = newHead;
                newHead = t;
                next = h;
            }

            ListNode newHead1 = newHead;
            ListNode newHead2 = next;
            if (len % 2 == 1) newHead2 = next.next;

            for(int i=0; i<len/2; i++) {
                if (newHead1.val != newHead2.val) return false;
                newHead1 = newHead1.next;
                newHead2 = newHead2.next;
            }
            // TODO: restore

            return true;
        }
    }
    public static class UnitTest {
        @Test
        public void testPalindromeLinkedList() {
            Solution s = new PalindromeLinkedList().new Solution();
            ListNode a = new ListNode(1);
            ListNode a1 = new ListNode(4);
            ListNode a2 = new ListNode(-1);
            ListNode a3 = new ListNode(4);
            ListNode a4 = new ListNode(2);
            a.next = a1;
            a1.next = a2;
            a2.next = a3;
            a3.next = a4;
            //a4.next = a5;
            assertTrue(!s.isPalindrome(a));
        }
    }
}

