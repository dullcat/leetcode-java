package construct_string_from_binary_tree;

import java.util.*;

import common.TreeNode;
import org.junit.*;
import static org.junit.Assert.*;

public class ConstructStringfromBinaryTree {

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
        public String tree2str(TreeNode t) {
            StringBuilder sb = new StringBuilder();
            if (t == null) {
                return "";
            }
            else {
                sb.append(t.val);
                if (t.left == null) {
                    if (t.right != null) {
                        sb.append(String.format("()(%s)", tree2str(t.right)));
                    }
                }
                else {//if (t.left != null) {
                    sb.append(String.format("(%s)", tree2str(t.left)));
                    if (t.right != null) {
                        sb.append(String.format("(%s)", tree2str(t.right)));
                    }
                }
            }
            return sb.toString();
        }
    }
    public static class UnitTest {
        @Test
        public void testConstructStringfromBinaryTree() {
            Solution s = new ConstructStringfromBinaryTree().new Solution();
        }
    }
}

