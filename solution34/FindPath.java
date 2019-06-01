package solution34;

import solution26.TreeNode;

import java.util.ArrayList;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * <p>
 * 下图的二叉树有两条和为 22 的路径：10, 5, 7 和 10, 12
 * 10
 * 5        12
 * 4    7
 */
public class FindPath {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        findPath(root, target, new ArrayList<Integer>());
        return result;
    }

    private void findPath(TreeNode root, int target, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target = target - root.val;
        if (target == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
        } else {
            findPath(root.left, target, path);
            findPath(root.right, target, path);
        }
        path.remove(path.size() - 1);
    }
}
