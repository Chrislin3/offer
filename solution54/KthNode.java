package solution54;
/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 * 利用二叉查找树中序遍历有序的特点。
 */

import solution26.TreeNode;

public class KthNode {
    private static TreeNode ret;
    private static int num = 0;
    public static TreeNode kthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k < 1) {
            return null;
        }
        inOrder(pRoot, k);
        return ret;
    }

    private static void inOrder(TreeNode pRoot, int k) {
        if (pRoot == null || num >= k) {
            return;
        }
        inOrder(pRoot.left, k);
        num++;
        if (num == k) {
            ret = pRoot;
        }
        inOrder(pRoot.right, k);
    }

    public static void main(String[] args) {
        TreeNode pRoot = new TreeNode(8);
        pRoot.left = new TreeNode(6);
        pRoot.right = new TreeNode(10);
        pRoot.left.left = new TreeNode(5);
        pRoot.left.right = new TreeNode(7);
        pRoot.right.left = new TreeNode(9);
        pRoot.right.right = new TreeNode(11);
        System.out.print(kthNode(pRoot,2).val);
    }

}
