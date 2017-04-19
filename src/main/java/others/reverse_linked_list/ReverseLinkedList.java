package others.reverse_linked_list;

import others.common.ListNode;

public class ReverseLinkedList {

    public class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode reversed = null;
            ListNode p = head;
            while (p != null) {
                ListNode temp = p.next;
                p.next = reversed;
                reversed = p;
                p = temp;
            }
            return reversed;
        }
    }
}

