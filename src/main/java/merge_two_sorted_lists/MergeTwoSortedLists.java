package merge_two_sorted_lists;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import common.ListNode;

public class MergeTwoSortedLists {

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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode res = new ListNode(0);
            ListNode cur = res;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                    cur = cur.next;
                }
                else {
                    cur.next = l2;
                    l2 = l2.next;
                    cur = cur.next;
                }
            }
            if (l1 == null) cur.next = l2;
            else cur.next = l1;
            return res.next;
        }
    }
    public static class UnitTest {
        @Test
        public void testMergeTwoSortedLists() {
            Solution s = new MergeTwoSortedLists().new Solution();
        }
    }
}

