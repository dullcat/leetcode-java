package others.same_tree;

import others.common.TreeNode;

public class SameTree {

    public class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == q) {
                return true;
            }
            if (p != null && q != null) {
                return p.val == q.val && isSameTree(p.left, q.left)
                        && isSameTree(p.right, q.right);
            }
            return false;
        }
    }

    public static class UnitTest {

    }
}