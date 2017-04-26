package flatten_binary_tree_to_linked_list;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import common.TreeNode;
public class FlattenBinaryTreetoLinkedList {

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
        public void flatten(TreeNode root) {
            helper(root);
        }

        TreeNode helper(TreeNode root) {
            if (root == null) return null;
            TreeNode leftHead = null;
            TreeNode leftTail = null;
            if (root.left != null) {
                leftHead = root.left;
                leftTail = helper(root.left);
            }
            TreeNode rightHead = null;
            TreeNode rightTail = null;
            if (root.right != null) {
                rightHead = root.right;
                rightTail = helper(root.right);
            }

            root.left = null;
            TreeNode curTail = root;
            if (leftHead != null) {
                curTail.right = leftHead;
                leftHead.left = curTail;
                curTail = leftTail;
            }
            if (rightHead != null) {
                curTail.right = rightHead;
                rightHead.left = curTail;
                curTail = rightTail;
            }
            return curTail;
        }

        // Non-recursive solution from others. https://discuss.leetcode.com/topic/3995/share-my-simple-non-recursive-solution-o-1-space-complexity/12
        public void flatten1(TreeNode root) {
            TreeNode cur = root;
            while (cur != null) {
                if (cur.left != null) {
                    TreeNode last = cur.left;
                    while (last.right != null) last = last.right;
                    last.right = cur.right;
                    cur.right = cur.left;
                    cur.left = null;
                }
                cur = cur.right;
            }
        }
    }
    public static class UnitTest {
        @Test
        public void testFlattenBinaryTreetoLinkedList() {
            Solution s = new FlattenBinaryTreetoLinkedList().new Solution();
            TreeNode a1 = new TreeNode(1);
            TreeNode a2 = new TreeNode(2);
            a1.left = a2;
            s.flatten(a1);
        }
    }
}

