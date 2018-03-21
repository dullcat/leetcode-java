package average_of_levels_in_binary_tree;

import java.util.*;

import common.TreeNode;
import org.junit.*;
import static org.junit.Assert.*;

public class AverageofLevelsinBinaryTree {

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
        public List<Double> averageOfLevels(TreeNode root) {
            ArrayList<Double> res = new ArrayList<Double>();
            if (root == null) return res;
            Stack<TreeNode> curLevel = new Stack<TreeNode>();
            Stack<TreeNode> nextLevel = new Stack<TreeNode>();
            curLevel.push(root);
            int level = 0;
            double num = 0;
            double sum = 0;
            while(!curLevel.isEmpty()) {
                while(!curLevel.isEmpty()) {
                    TreeNode n = curLevel.pop();
                    num += 1;
                    sum += n.val;
                    if (n.left != null) nextLevel.push(n.left);
                    if (n.right != null) nextLevel.push(n.right);
                }
                res.add(sum / num);
                num = 0;
                sum = 0;
                Stack<TreeNode> temp = curLevel;
                curLevel = nextLevel;
                nextLevel = temp;
            }
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testAverageofLevelsinBinaryTree() {
            Solution s = new AverageofLevelsinBinaryTree().new Solution();
        }
    }
}

