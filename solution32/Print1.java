package solution32;
/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */

import solution26.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Print1 {

    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int num = queue.size();
            while (num-- > 0){
                TreeNode cur = queue.poll();

                if(cur == null){
                    continue;
                }
                result.add(cur.val);
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }

        return result;
    }
}
