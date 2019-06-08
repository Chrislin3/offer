package solution56;

import java.util.HashSet;
import java.util.Set;

public class FindNumsAppearOnce {
    public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length == 0) {
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int val : array) {
            if (set.contains(val)) {
                set.remove(val);
            } else {
                set.add(val);
            }
        }
        int i = 0;
        for (Integer a : set) {
            if (i == 0) {
                num1[0] = a;
                i++;
            } else {
                num2[0] = a;
            }
        }

    }
    public static void main(String[] args) {
        int[] arr = {2,4,3,6,3,2,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce findNumsAppearOnce = new FindNumsAppearOnce();
        findNumsAppearOnce.findNumsAppearOnce(arr, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
