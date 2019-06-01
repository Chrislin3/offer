package solution6;
/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
//使用栈的先进后出来完成
//注意不要忘了导包！！！

import java.util.ArrayList;
import java.util.Stack;

public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ListNode cur = listNode;
        Stack<Integer> stack = new Stack<Integer>();
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        while (!(stack.empty())) {
            arr.add(stack.pop());
        }
        return arr;
    }
}
