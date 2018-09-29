package nary_tree_postorder_traversal;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class NaryTreePostorderTraversal {
//    Given an n-ary tree, return the postorder traversal of its nodes' values.
//
//
//    For example, given a 3-ary tree:
//
//
//
//
//    Return its postorder traversal as: [5,6,3,2,4,1].
//
//
//    Note: Recursive solution is trivial, could you do it iteratively?
//

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
};
    class Solution {
        public List<Integer> postorder(Node root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node cur = stack.pop();
                res.add(cur.val);
                for (Node node: cur.children) {
                    stack.push(node);
                }
            }
            Collections.reverse(res);
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testNaryTreePostorderTraversal() {
            Solution s = new NaryTreePostorderTraversal().new Solution();
        }
    }
}

