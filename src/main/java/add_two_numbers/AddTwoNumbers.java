package add_two_numbers;

import common.ListNode;

public class AddTwoNumbers {

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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int c = 0;
            ListNode res = new ListNode(0);
            ListNode cur = res;
            while (l1 != null || l2 != null || c > 0) {
                cur.next = new ListNode(c);
                c = 0;
                cur = cur.next;
                if (l1 != null) {
                    cur.val += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    cur.val += l2.val;
                    l2 = l2.next;
                }
                if (cur.val >= 10) {
                    cur.val -= 10;
                    c = 1;
                }
            }

            return res.next == null ? res : res.next;
        }
    }
    public static class UnitTest {

    }
}

