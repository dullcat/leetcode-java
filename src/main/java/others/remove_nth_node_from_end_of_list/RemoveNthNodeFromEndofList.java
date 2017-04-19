package others.remove_nth_node_from_end_of_list;

import others.common.ListNode;

public class RemoveNthNodeFromEndofList {

    public class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode fast = head;
            while (n > 1) {
                fast = fast.next;
                n--;
            }
            if (fast.next == null) {
                return head.next;
            }
            ListNode slow = head;
            fast = fast.next;
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
            return head;
        }
    }

    public static class UnitTest {

    }
}
