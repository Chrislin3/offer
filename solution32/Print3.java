package solution32;

import solution26.TreeNode;

import java.util.*;

/**
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Print3 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int ceng = 1;
        while (!queue.isEmpty()) {
            ceng++;
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
            if (ceng % 2 == 1) {
                Collections.reverse(retCur);
            }
            if (!retCur.isEmpty()) {
                result.add(retCur);
            }

        }
        return result;
    }
}
