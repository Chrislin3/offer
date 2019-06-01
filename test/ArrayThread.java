package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayThread {
    public static void main(String[] args) throws InterruptedException {
        final List<Integer> list = new ArrayList<Integer>();
        List<Integer> list2 = Collections.synchronizedList(list);
        // 线程A将0-1000添加到list
        Thread thread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    list2.add(i);

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // 线程B将1000-2000添加到列表
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 1000; i < 2000; i++) {
                    list2.add(i);

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();
        thread.join();

        thread1.start();

        thread1.join();
//        Thread.sleep(300);

        // 打印所有结果
        for (int i = 0; i < list2.size(); i++) {
            System.out.println("第" + (i + 1) + "个元素为：" + list2.get(i));
        }
    }

}
