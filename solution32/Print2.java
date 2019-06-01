package solution32;
/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */

import solution26.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Print2 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            int num = queue.size();
            ArrayList<Integer> retCur = new ArrayList<>();
            while (num-- > 0) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    continue;
                }
                retCur.add(cur.val);
                queue.add(cur.left);
                queue.add(cur.right);

            }
            if (!retCur.isEmpty()) {
                result.add(retCur);
            }

        }
        return result;
    }
}
