package solution57;
/**
 * 输出所有和为 S 的连续正数序列。
 *
 * 例如和为 100 的连续序列有：
 * [9, 10, 11, 12, 13, 14, 15, 16]
 * [18, 19, 20, 21, 22]。
 */

import java.util.ArrayList;

public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        if (sum <= 0) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int start = 1;
        int end = 2;
        int mysum = 3;
        while (end < sum) {
            if (mysum < sum) {
                end++;
                mysum += end;
            } else if (mysum > sum) {
                mysum -= start;
                start++;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                res.add(list);
                mysum -= start;
                start++;
                end++;
                mysum += end;
            }
        }
        return res;
    }
}
