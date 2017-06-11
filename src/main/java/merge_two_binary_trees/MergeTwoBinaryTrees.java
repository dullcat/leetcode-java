package merge_two_binary_trees;

import java.util.*;

import common.TreeNode;
import org.junit.*;
import static org.junit.Assert.*;

public class MergeTwoBinaryTrees {

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
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) return null;
            TreeNode t;
            if (t1 != null && t2 != null) {
                t = new TreeNode(t1.val+t2.val);
                t.left = mergeTrees(t1.left, t2.left);
                t.right = mergeTrees(t1.right, t2.right);
            }
            else if (t1 == null) {
                t = new TreeNode(t2.val);
                t.left = mergeTrees(null, t2.left);
                t.right = mergeTrees(null, t2.right);
            }
            else {
                t = new TreeNode(t1.val);
                t.left = mergeTrees(t1.left, null);
                t.right = mergeTrees(t1.right, null);
            }
            return t;
        }
    }
    public static class UnitTest {
        @Test
        public void testMergeTwoBinaryTrees() {
            Solution s = new MergeTwoBinaryTrees().new Solution();
        }
    }
}

