package solution31;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * <p>
 * 例如序列 1,2,3,4,5 是某栈的压入顺序，序列 4,5,3,2,1 是该压栈序列对应的一个弹出序列，
 * 但 4,3,5,1,2 就不可能是该压栈序列的弹出序列。
 */
public class IsPopOrder {
    public boolean isPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int len = pushA.length;
        for (int pointPush = 0, pointPop = 0; pointPush < len; pointPush++) {
            stack.push(pushA[pointPush]);
            while (!stack.isEmpty() && stack.peek() == popA[pointPop] && pointPop < len) {
                stack.pop();
                pointPop++;
            }
        }
        return stack.isEmpty();
    }
}
