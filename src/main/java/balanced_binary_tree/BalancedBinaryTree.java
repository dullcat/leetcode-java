package balanced_binary_tree;

import java.util.*;

import common.TreeNode;
import org.junit.*;
import static org.junit.Assert.*;

public class BalancedBinaryTree {
//    Given a binary tree, determine if it is height-balanced.
//
//            For this problem, a height-balanced binary tree is defined as:
//
//    a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//
//    Example 1:
//
//    Given the following tree [3,9,20,null,null,15,7]:
//
//            3
//            / \
//            9  20
//            /  \
//            15   7
//    Return true.
//
//    Example 2:
//
//    Given the following tree [1,2,2,3,3,null,null,4,4]:
//
//            1
//            / \
//            2   2
//            / \
//            3   3
//            / \
//            4   4
//    Return false.
//

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
        public boolean isBalanced(TreeNode root) {
            return getDepth(root)!=-1;
        }

        // return depth when balanced. -1 if not balanced.
        private int getDepth(TreeNode root) {
            if (root == null) return 0;
            int left = getDepth(root.left);
            int right = getDepth(root.right);
            if (left==-1 || right==-1 || Math.abs(left-right)>1) return -1;
            return Math.max(left, right) + 1;
        }
    }
    public static class UnitTest {
        @Test
        public void testBalancedBinaryTree() {
            Solution s = new BalancedBinaryTree().new Solution();
        }
    }
}

