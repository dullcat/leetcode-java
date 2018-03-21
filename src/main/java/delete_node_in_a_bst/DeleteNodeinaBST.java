package delete_node_in_a_bst;

import java.util.*;

import common.TreeNode;
import org.junit.*;
import static org.junit.Assert.*;

public class DeleteNodeinaBST {

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
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return null;
            TreeNode parent = null;
            TreeNode cur = root;

            // find key
            while (cur != null) {
                if (cur.val == key) {
                    break;
                }
                parent = cur;
                if (cur.val < key) {
                    cur = cur.right;
                }
                else {
                    cur = cur.left;
                }
            }

            // not found
            if (cur == null) return root;

            TreeNode node = deleteRoot(cur);

            // found
            if (parent == null) {
                return node;
            }
            if (parent.left == cur) {
                parent.left = node;
            }
            else if (parent.right == cur) {
                parent.right = node;
            }
            return root;

        }

        TreeNode deleteRoot(TreeNode root) {
            if (root == null) return null;
            if (root.right == null) {
                return root.left;
            }

            TreeNode n = root.right;
            while (n.left != null) {
                n = n.left;
            }
            n.left = root.left;
            return root.right;
        }
    }
    public static class UnitTest {
        @Test
        public void testDeleteNodeinaBST() {
            Solution s = new DeleteNodeinaBST().new Solution();
            s.deleteNode(null, 0);
        }
    }
}

