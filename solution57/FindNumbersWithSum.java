package solution57;
/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 对应每个测试案例，输出两个数，小的先输出。
 * 分析：
 * 使用双指针，一个指针指向元素较小的值，一个指针指向元素较大的值。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
 * 如果两个指针指向元素的和 sum == target，那么得到要求的结果；（越往外层乘积越小，没必要往里面缩了）
 * 如果 sum > target，移动较大的元素，使 sum 变小一些；
 * 如果 sum < target，移动较小的元素，使 sum 变大一些。
 */

import java.lang.reflect.Array;
import java.util.*;

public class FindNumbersWithSum {
    public static ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        if (array == null || array.length == 0) {
            return new ArrayList<>();
        }

        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            if (array[start] + array[end] > sum) {
                end--;
            } else if (array[start] + array[end] < sum) {
                start++;
            } else {

                ArrayList<Integer> res = new ArrayList<>(Arrays.asList(array[start], array[end]));
                return res;
            }
        }
        return new ArrayList<>();

    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,7,11,16};
        System.out.print(findNumbersWithSum(arr,10).toString());
    }
}
