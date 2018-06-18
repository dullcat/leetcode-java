package two_sum_iv_bst;

import java.util.*;

import common.TreeNode;
import org.junit.*;
import static org.junit.Assert.*;

public class TwoSumIVBST {

    // Insert your Solution class here
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean findTarget(TreeNode root, int k) {
            if (root == null) return false;
            return findsub(root, root, k);
        }
        boolean findsub(TreeNode root, TreeNode cur, int k) {
            if (cur == null) return false;
            if (cur.val != k-cur.val) {
                if (find(root, k-cur.val)) return true;
            }
            return findsub(root, cur.left, k) || findsub(root, cur.right, k);
        }
        boolean find(TreeNode root, int v) {
            if (root == null) return false;
            if (root.val == v) return true;
            if (root.val < v) return find(root.right, v);
            else return find(root.left, v);
        }
    }
    public static class UnitTest {
        @Test
        public void testTwoSumIVBST() {
            Solution s = new TwoSumIVBST().new Solution();
        }
    }
}

