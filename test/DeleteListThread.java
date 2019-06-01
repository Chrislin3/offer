package test;

import java.util.List;

public class DeleteListThread extends Thread {
    private List<Integer> nums;

    public DeleteListThread(List<Integer> nums) {
        super("DeleteListThread");
        this.nums = nums;
    }

    // 删除第一个元素
    public void run() {
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName() + ":" + nums.remove(0));
            } catch (Exception e) {
                continue;
            }

        }
    }
}
