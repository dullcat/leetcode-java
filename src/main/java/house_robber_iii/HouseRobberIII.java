package house_robber_iii;

import java.util.*;

import common.TreeNode;
import org.junit.*;
import static org.junit.Assert.*;

public class HouseRobberIII {

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
        public int rob(TreeNode root) {
            if (root == null) return 0;

            int resNoRoot = 0;
            TreeNode left = root.left;
            TreeNode right = root.right;
            resNoRoot = rob(left) + rob(right); // not select root

            int resRoot = root.val;
            if (left != null) {
                resRoot += rob(left.left);
                resRoot += rob(left.right);
            }
            if (right != null) {
                resRoot += rob(right.left);
                resRoot += rob(right.right);
            }

            return Math.max(resNoRoot, resRoot);
        }
    }
    public static class UnitTest {
        @Test
        public void testHouseRobberIII() {
            Solution s = new HouseRobberIII().new Solution();
        }
    }
}

