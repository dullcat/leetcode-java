package nary_tree_preorder_traversal;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class NaryTreePreorderTraversal {
//    Given an n-ary tree, return the preorder traversal of its nodes' values.
//
//
//    For example, given a 3-ary tree:
//
//
//
//
//    Return its preorder traversal as: [1,3,5,6,2,4].
//
//
//    Note: Recursive solution is trivial, could you do it iteratively?

    // Insert your Solution class here

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}

    class Solution {
        public List<Integer> preorder(Node root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;

            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node cur = stack.pop();
                res.add(cur.val);
                for (int i=cur.children.size()-1; i>=0; i--) {
                    stack.push(cur.children.get(i));
                }
            }
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testNaryTreePreorderTraversal() {
            Solution s = new NaryTreePreorderTraversal().new Solution();
        }
    }
}

