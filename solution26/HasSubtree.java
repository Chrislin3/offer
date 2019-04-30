package solution26;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */

/**
 * 首先以当前根节点为起点，把root2遍历结束查看是否是子树，
 * 若发现为假，则返回当前根，并把左子节点作为当前根，继续上述过程
 * 若一直没有匹配，则用右节点继续
 */
public class HasSubtree {
    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null){
            return false;
        }
        return isSubTree(root1, root2) || hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);

    }
    private boolean isSubTree(TreeNode root1, TreeNode root2){
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);

    }


}
