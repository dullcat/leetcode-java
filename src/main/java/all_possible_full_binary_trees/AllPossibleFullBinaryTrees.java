package all_possible_full_binary_trees;

import java.util.*;

import common.TreeNode;
import org.junit.*;
import static org.junit.Assert.*;

public class AllPossibleFullBinaryTrees {
//    A full binary tree is a binary tree where each node has exactly 0 or 2 children.
//
//    Return a list of all possible full binary trees with N nodes.  Each element of the answer is the root node of one possible tree.
//
//    Each node of each tree in the answer must have node.val = 0.
//
//    You may return the final list of trees in any order.
//
//
//
//    Example 1:
//
//    Input: 7
//    Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
//    Explanation:
//
//    Note:
//
//            1 <= N <= 20

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
        public List<TreeNode> allPossibleFBT(int N) {
            List<TreeNode> res = new ArrayList<TreeNode>();
            if (N == 0) return res;
            if (N % 2 == 0) return res;
            if (N == 1) {
                res.add(new TreeNode(0));
                return res;
            }
            int n = 1;
            while (n < N) {
                for (TreeNode left: allPossibleFBT(n)) {
                    for (TreeNode right: allPossibleFBT(N-n-1)) {
                        TreeNode root = new TreeNode(0);
                        root.left = left;
                        root.right = right;
                        res.add(root);
                    }
                }
                n += 2;
            }
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testAllPossibleFullBinaryTrees() {
            Solution s = new AllPossibleFullBinaryTrees().new Solution();
        }
    }
}

