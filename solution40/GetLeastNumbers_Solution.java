package solution40;
/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */

import java.util.ArrayList;
import java.util.PriorityQueue;

public class GetLeastNumbers_Solution {
    public ArrayList<Integer> getLeastNumbers_Solution(int [] input, int k) {
        if (input.length < k || k <= 0) {
            return new ArrayList<>();
        }
        //构建大根堆
        PriorityQueue<Integer> maxLeap = new PriorityQueue<>((o1, o2) -> o2-o1);

        for (int num : input) {
            //把数组中的所有值都放进大根堆中
            maxLeap.add(num);
            //如果堆中的值超过了看，那么就把堆顶（此时的最大值）弹出，最后剩下的k个值，自然就是最小的k个值
            if (maxLeap.size() > k) {
                maxLeap.poll();
            }
        }
        return new ArrayList<>(maxLeap);
    }
}
