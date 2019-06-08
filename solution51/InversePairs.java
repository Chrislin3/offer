package solution51;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */


public class InversePairs {
    private int [] help;
    private long res = 0;

    public int inversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int p = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    p++;
                }
            }
        }
        return p  % 1000000007;
    }

    public int inversePairs2(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        help = new int[array.length];
        mergeSort(array, 0, array.length - 1);
//        for (int val : array) {
//            System.out.print(val);
//            System.out.print(" ");
//        }
        return (int) (res % 1000000007);

    }

    private void mergeSort(int[] array, int l, int h) {
        if (l == h) {
            return;
        }
        int m = (l + h) / 2;
        mergeSort(array, l, m);
        mergeSort(array, m + 1, h);
        merge(array, l, m, h);
    }

    private void merge(int[] array, int l, int m, int h) {
        int i = l;
        int j = m + 1;
        int k = l;
        while (i <= m || j <= h) {
            if (i > m) {
                help[k++] = array[j++];
            } else if (j > h) {
                help[k++] = array[i++];
            } else if (array[i] <= array[j]) {
                help[k++] = array[i++];
            } else {
                help[k++] = array[j++];
                res += m - i + 1;
            }
        }
        for (int a = l; a <= h; a++) {
            array[a] = help[a];
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 0};

        InversePairs inversePairs = new InversePairs();
        System.out.println(inversePairs.inversePairs2(array));
    }
}
