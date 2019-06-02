package solution45;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    public static class Mycomparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }
    public static String printMinNumber(int [] numbers) {
        if (numbers == null) {
            return null;
        }
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = numbers[i] + "";
        }

        //利用小根堆的方式
        PriorityQueue<String> queue = new PriorityQueue<>(new Mycomparator());
        for (String num : nums) {
            queue.add(num);
        }
        String res = "";
        while (!queue.isEmpty()) {
            res += queue.poll();
        }

        //lambda 表达式方式
//      Arrays.sort(nums,((o1, o2) -> (o1+o2).compareTo(o2+o1)));
        //自定义比较器方式
//        Arrays.sort(nums,new Mycomparator());
//        String res = "";
//        for (String num : nums) {
//            res += num;
//        }
        return res;
    }

    public static void main(String[] args) {
        System.out.print(printMinNumber(new int[]{3, 32, 321}));
    }
}
