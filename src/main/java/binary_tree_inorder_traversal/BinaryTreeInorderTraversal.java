package binary_tree_inorder_traversal;

import java.util.*;

import common.TreeNode;
import org.junit.*;
import static org.junit.Assert.*;

public class BinaryTreeInorderTraversal {
//    Given a binary tree, return the inorder traversal of its nodes' values.
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
//    Output: [1,3,2]
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            if (root == null) return res;
            stack.push(root);
            TreeNode cur = root;
            while (cur.left != null) {
                stack.push(cur.left);
                cur = cur.left;
            }
            while (!stack.isEmpty()) {
                cur = stack.pop();
                res.add(cur.val);
                if (cur.right != null)
                {
                    stack.push(cur.right);
                    cur = cur.right;
                    //System.out.println(cur.val);
                    while (cur.left != null) {
                        stack.push(cur.left);
                        cur = cur.left;
                    }
                }
                //System.out.println(res);
            }
            return res;
        }
    }
    class Solution2 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            if (root == null) return res;
            stack.push(root);
            TreeNode cur = root;
            while (cur.left != null) {
                stack.push(cur.left);
                cur = cur.left;
            }
            while (!stack.isEmpty()) {
                cur = stack.pop();
                res.add(cur.val);
                if (cur.right != null)
                {
                    stack.push(cur.right);
                    cur = cur.right;
                    //System.out.println(cur.val);
                    while (cur.left != null) {
                        stack.push(cur.left);
                        cur = cur.left;
                    }
                }
                //System.out.println(res);
            }
            return res;
        }
    }
    class Solution1 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            rec(root, res);
            return res;
        }
        private void rec(TreeNode root, List<Integer> res) {
            if (root == null) return;
            rec(root.left, res);
            res.add(root.val);
            rec(root.right, res);
        }
    }
    public static class UnitTest {
        @Test
        public void testBinaryTreeInorderTraversal() {
            Solution s = new BinaryTreeInorderTraversal().new Solution();
        }
    }
}

