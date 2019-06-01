package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyArrayList {
    /**
     * 创建一个列表，一个线程进行写入，一个线程读取 iterator 和 listIterator 方法返回的迭代器是快速失败的
     */
    public void readWrite() {
        List<Integer> nums = new ArrayList<>();

        List<Integer> synNums = Collections.synchronizedList(nums);

        //启动写入线程
        new WriteListThread(nums).start();

        //启动删除线程
        new DeleteListThread(nums).start();
    }

    public static void main(String[] args) {
        new MyArrayList().readWrite();
    }
}
