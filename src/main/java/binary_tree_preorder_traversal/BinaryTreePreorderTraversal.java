package binary_tree_preorder_traversal;

import java.util.*;

import common.TreeNode;
import org.junit.*;
import static org.junit.Assert.*;

public class BinaryTreePreorderTraversal {
//    Given a binary tree, return the preorder traversal of its nodes' values.
//
//    Example:
//
//    Input: [1,null,2,3]
//            1
//            \
//            2
//            /
//            3
//
//    Output: [1,2,3]
//    Follow up: Recursive solution is trivial, could you do it iteratively?


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
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                res.add(cur.val);
                if (cur.right != null) stack.push(cur.right);
                if (cur.left != null) stack.push(cur.left);
            }
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testBinaryTreePreorderTraversal() {
            Solution s = new BinaryTreePreorderTraversal().new Solution();
        }
    }
}

