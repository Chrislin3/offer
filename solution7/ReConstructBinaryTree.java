package solution7;
/**
 * 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
//难点
import java.util.HashMap;

public class ReConstructBinaryTree {
    private HashMap<Integer,Integer> inMap = new HashMap<>();
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if(pre == null || in == null){
            return null;
        }

        for(int i = 0;i<in.length;i++){
            inMap.put(in[i],i);  //将数组索引作为值，数组的值作为键
        }
        return reConstructBinaryTree(pre,0, pre.length - 1, 0);

    }
    private TreeNode reConstructBinaryTree(int [] pre, int preFirst, int preLast, int inFirst){
        if(preFirst > preLast){  //递归基本条件
            return null;
        }
        TreeNode root = new TreeNode(pre[preFirst]);//将前序的第一个值作为根
        int indexIn = inMap.get(pre[preFirst]);  //得到前序的第一个值的索引
        int leftLength = indexIn - inFirst;      //得到构建左子树的长度
        root.left = reConstructBinaryTree(pre, preFirst + 1, preFirst + leftLength, inFirst);
        root.right = reConstructBinaryTree(pre,preFirst + leftLength + 1,  preLast, inFirst + leftLength + 1);
        return root;
    }
}
