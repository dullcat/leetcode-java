package add_one_row_to_tree;

import java.util.*;

import common.TreeNode;
import org.junit.*;
import static org.junit.Assert.*;

public class AddOneRowtoTree {

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
        public TreeNode addOneRow(TreeNode root, int v, int d) {
            if (d < 1) return root;
            if (d == 1) {
                TreeNode newRoot = new TreeNode(v);
                newRoot.left = root;
                return newRoot;
            }
            if (root == null) return null;
            if (d == 2) {
                TreeNode newLeft = new TreeNode(v);
                newLeft.left = root.left;
                root.left = newLeft;
                TreeNode newRight = new TreeNode(v);
                newRight.right = root.right;
                root.right = newRight;
                return root;
            }
            root.left = addOneRow(root.left, v, d-1);
            root.right = addOneRow(root.right, v, d-1);
            return root;
        }
    }
    public static class UnitTest {
        @Test
        public void testAddOneRowtoTree() {
            Solution s = new AddOneRowtoTree().new Solution();
        }
    }
}

