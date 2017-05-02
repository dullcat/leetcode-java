package validate_binary_search_tree;

import java.util.*;

import common.TreeNode;
import org.junit.*;
import static org.junit.Assert.*;

public class ValidateBinarySearchTree {

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
    public class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        boolean isValidBST(TreeNode root, int low, int high) {
            if (root == null) return true;
            if (root.val < low || root.val > high) return false;
            return isValidBST(root.left, low, Math.min(high, root.val))
                    && isValidBST(root.right, Math.max(low, root.val), high);
        }
    }


    public class Solution1 {
        TreeNode pre = null;
        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            boolean left = isValidBST(root.left);
            if (pre != null && root.val <= pre.val) return false;
            if (pre == null) {
                pre = new TreeNode(Integer.MIN_VALUE);
            }
            pre.val = root.val;
            return left && isValidBST(root.right);
        }

    }
    public static class UnitTest {
        @Test
        public void testValidateBinarySearchTree() {
            Solution1 s = new ValidateBinarySearchTree().new Solution1();

            TreeNode a1 = new TreeNode(3);
            TreeNode a2 = new TreeNode(1);
            TreeNode a3 = new TreeNode(5);
            TreeNode a4 = new TreeNode(0);
            TreeNode a5 = new TreeNode(2);
            TreeNode a6 = new TreeNode(4);
            TreeNode a7 = new TreeNode(6);

            a1.left = a2; a1.right = a3;
            a2.left = a4; a2.right = a5;
            a3.left = a6; a3.right = a7;
            assertEquals(true, s.isValidBST(a1));
        }
    }
}

