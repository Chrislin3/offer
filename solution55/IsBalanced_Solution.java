package solution55;
/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */

import solution26.TreeNode;

public class IsBalanced_Solution {
    public static class ReturnData {
        public boolean isB;
        public int height;

        public ReturnData(boolean isB, int height) {
            this.isB = isB;
            this.height = height;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        ReturnData res = process(root);
        return res.isB;
    }

    private static ReturnData process(TreeNode root) {
        if (root == null) {
            return new ReturnData(true, 0);
        }

        ReturnData leftData = process(root.left);
        if (!leftData.isB) {
            return new ReturnData(false, 0);
        }

        ReturnData rightData = process(root.right);
        if (!rightData.isB) {
            return new ReturnData(false, 0);
        }

        if (Math.abs(rightData.height - leftData.height) > 1) {
            return new ReturnData(false, 0);
        }

        return new ReturnData(true, Math.max(leftData.height, rightData.height) + 1);
    }
}
