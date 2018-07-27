package range_sum_query_mutable;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class RangeSumQueryMutable {
//    Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
//
//    The update(i, val) function modifies nums by updating the element at index i to val.
//
//    Example:
//
//    Given nums = [1, 3, 5]
//
//    sumRange(0, 2) -> 9
//    update(1, 2)
//    sumRange(0, 2) -> 8
//    Note:
//
//    The array is only modifiable by the update function.
//    You may assume the number of calls to update and sumRange function is distributed evenly.

    // Insert your Solution class here
    class NumArray {
        class Node {
            int sum;
            int s, e;
            Node left, right;
            public Node(int s, int e) {
                this.s = s;
                this.e = e;
            }
        }
        Node root;
        public NumArray(int[] nums) {
            if (nums == null || nums.length == 0) return;
            root = buildST(nums, 0, nums.length-1);
        }
        private Node buildST(int[] nums, int s, int e) {
            Node node = new Node(s, e);
            if (s == e) {
                node.sum = nums[s];
                return node;
            }

            int mid = s + (e-s) / 2;
            node.left = buildST(nums, s, mid);
            node.right = buildST(nums, mid+1, e);
            node.sum = node.left.sum + node.right.sum;
            return node;
        }

        public void update(int i, int val) {
            int diff = val - sumRange(i, i);
            update(root, i, diff);
        }
        private void update(Node root, int i, int diff) {
            if (root != null && root.s <= i && i <= root.e) {
                root.sum += diff;
                update(root.left, i, diff);
                update(root.right, i, diff);
            }
        }

        public int sumRange(int i, int j) {
            return sumRange(root, i, j);
        }
        private int sumRange(Node root, int i, int j) {
            if (root == null || root.e < i || root.s > j) return 0;
            else if (i <= root.s && j >= root.e) return root.sum;
            else {
                return sumRange(root.left, i, j) + sumRange(root.right, i, j);
            }
        }
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * obj.update(i,val);
     * int param_2 = obj.sumRange(i,j);
     */
    public static class UnitTest {
        @Test
        public void testRangeSumQueryMutable() {
            //Solution s = new RangeSumQueryMutable().new Solution();
        }
    }
}

