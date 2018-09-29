package binary_tree_postorder_traversal;

import java.util.*;

import common.TreeNode;
import org.junit.*;
import static org.junit.Assert.*;

public class BinaryTreePostorderTraversal {
//    Given a binary tree, return the postorder traversal of its nodes' values.
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
//    Output: [3,2,1]
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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                res.add(cur.val);
                if (cur.left != null) stack.push(cur.left);
                if (cur.right != null) stack.push(cur.right);
            }
            Collections.reverse(res);
            return res;
        }
    }
    class Solution2 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            TreeNode last = null;

            while (!stack.isEmpty()) {
                TreeNode cur = stack.peek();
                System.out.println(cur.val);
                if (last == null || last.left == cur || last.right == cur) {
                    if (cur.left != null) {
                        stack.push(cur.left);
                    }
                    else if (cur.right != null){
                        stack.push(cur.right);
                    }
                    else {
                        res.add(cur.val);
                        stack.pop();
                    }
                }
                else {
                    if (cur.left == last && cur.right != null) {
                        stack.push(cur.right);
                    }
                    else {
                        res.add(cur.val);
                        stack.pop();
                    }
                }
                last = cur;
            }
            return res;
        }
    }
    class Solution1 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            rec(root, res);
            return res;
        }

        private void rec(TreeNode root, List<Integer> res) {
            if (root == null) return;
            rec(root.left, res);
            rec(root.right, res);
            res.add(root.val);
        }
    }
    public static class UnitTest {
        @Test
        public void testBinaryTreePostorderTraversal() {
            Solution s = new BinaryTreePostorderTraversal().new Solution();
        }
    }
}

