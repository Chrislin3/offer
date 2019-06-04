package solution53;

/**
 * 二分查找我所不知道的：
 * 在while循环之后，返回的l是什么：
 * （1）如果要找的数不在数组里
 *     A、比数组的最大值还大，那l就是数组的长度；
 *     B、比数组的最小值还小，那l就是0；
 *     C、在数值最小值和最大值之间，那返回的值就会是比数组大的那个值的索引后面，例如：
 *        在数组{1，2，3，5，6，8}查找4的索引，会返回3后面索引的3，查找7的索引，会返回6的后面索引5
 * （2）如果要找的数在数组里
 *      l的索引就是要查找的数在数组中第一次出现的位置！！！
 *
 *   综上，借助二分查找的性质，我们可以知道，k+1在数组的位置减去k在数组的位置，一定是k出现的次数。
 */
public class GetNumberOfK {
    public static int getNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int index_cur = getIndexOfK(array, k);
        int index_next = getIndexOfK(array, k + 1);
//        查看查找的数值在数组出现的位置
//        return index_cur;
        if (index_cur == array.length || array[index_cur] != k) {
            return 0;
        }
        return index_next - index_cur;
    }

    private static int getIndexOfK(int[] array, int k) {
        int l = 0;
        int h = array.length;

        while (l < h) {
            int mid = (l + h) / 2;
            if (array[mid] >= k) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int [] array = {0,2,2,2,3,5,6,8,9,10};
        System.out.print(getNumberOfK(array, 2));
    }
}
