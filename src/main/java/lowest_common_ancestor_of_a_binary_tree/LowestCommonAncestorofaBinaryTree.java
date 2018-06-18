package lowest_common_ancestor_of_a_binary_tree;

import java.util.*;

import common.TreeNode;
import org.junit.*;
import static org.junit.Assert.*;

public class LowestCommonAncestorofaBinaryTree {

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
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            List<TreeNode> listp = new ArrayList<>();
            List<TreeNode> listq = new ArrayList<>();
            if (findPath(root, p, listp) && findPath(root, q, listq)) {
                int i = 0;
                TreeNode res = null;
                while (i<listp.size() && i<listq.size() && listp.get(i) == listq.get(i)) {
                    res = listp.get(i);
                    i++;
                }
                return res;
            }
            return null;
        }

        private boolean findPath(TreeNode root, TreeNode node, List<TreeNode> path) {
            if (root == null) return false;

            path.add((root));

            if (root == node) {
                return true;
            }
            List<TreeNode> newPath = new ArrayList<>(path);
            if (root.left != null) {
                if (findPath(root.left, node, path)) return true;
            }
            if (root.right != null) {
                if (findPath(root.right, node, path)) return true;
            }

            path.remove(path.size()-1);
            return false;
        }
    }
    public static class UnitTest {
        @Test
        public void testLowestCommonAncestorofaBinaryTree() {
            Solution s = new LowestCommonAncestorofaBinaryTree().new Solution();
        }
    }
}

