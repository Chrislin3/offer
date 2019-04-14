package solution9;
/**
 * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。
 */

import java.util.Stack;

public class StackToQueue {
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() throws Exception {
        if(stack1.empty() && stack2.empty()){
            throw new Exception("queue is empty");
        }
        else if(stack2.empty()){
            while (! stack1.empty()){
                stack2.push(stack1.pop());

            }
            return stack2.pop();
        }
        else if(!stack2.empty()){
            return stack2.pop();
        }
       return 0;
    }
}
