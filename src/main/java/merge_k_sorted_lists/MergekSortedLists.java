package merge_k_sorted_lists;

import java.util.*;

import common.ListNode;
import org.junit.*;
import static org.junit.Assert.*;

public class MergekSortedLists {

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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == l2) return l1;
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
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;
            int s = 0; int e = lists.length - 1;

            while (s < e) {
                int mid1 = s + (s + e) / 2;
                int mid2 = s + (s + e + 1) / 2;
                for (int i=mid1, j=mid2; i>=0; i--, j++) {
                    lists[i] = mergeTwoLists(lists[i],lists[j]);
                }
                e = mid1;
            }
            return lists[0];
        }
    }
    public static class UnitTest {
        @Test
        public void testMergekSortedLists() {
            Solution s = new MergekSortedLists().new Solution();
        }
    }
}

