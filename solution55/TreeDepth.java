package solution55;
/**
 * 二叉树的深度
 * 记住结论吧
 */

import solution26.TreeNode;

public class TreeDepth {
    public static int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode pRoot = new TreeNode(8);
        pRoot.left = new TreeNode(6);
        pRoot.right = new TreeNode(10);
        pRoot.left.left = new TreeNode(5);
        pRoot.left.left.left = new TreeNode(4);
        pRoot.right.left = new TreeNode(9);
        pRoot.right.right = new TreeNode(11);
        System.out.print(treeDepth(pRoot));
    }
}
