package others.path_sum;

import org.junit.Test;

import others.common.TreeNode;

public class PathSum {

    public class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null) {
                return sum == root.val;
            }
            return hasPathSum(root.left, sum - root.val)
                    || hasPathSum(root.right, sum - root.val);
        }
    }

    public static class UnitTest {

        @Test
        public void test() {
            new PathSum().new Solution().hasPathSum(new TreeNode(1), 1);
        }
    }
}
