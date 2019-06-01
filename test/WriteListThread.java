package test;

import java.util.List;
import java.util.Random;

public class WriteListThread extends Thread {
    private List<Integer> nums;

    public WriteListThread(List<Integer> nums) {
        super("WriteListThread");
        this.nums = nums;
    }

    // 不停写入元素1
    public void run() {
        while (true) {
            int newEle = new Random().nextInt(1000);
            nums.add(newEle);
            System.out.println(Thread.currentThread().getName() + newEle);

        }
    }
}
