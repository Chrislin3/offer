package solution41;
/**
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 分析：
 * 用大根堆和小根堆结构，需要保证：
 * （1）大根堆的头（堆中最大值）比小根堆的头（堆中最小值）还要小
 * （2）两个堆中的数量保持平衡，差值不能超过1
 * 就可以保证中位数一定是在两个堆的头上：
 *  如果是奇数个，一定在个数较多的堆的顶部
 *  如果是偶数个，一定是两个堆顶的平均值
 */

import java.util.PriorityQueue;

public class MediumNum {
    /* 大顶堆，存储较小的一半元素 */
    private  static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    /* 小顶堆，存储较大的一半元素 */
    private  static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    /* 当前数据流读入的元素个数 */
    private  static int N = 0;

    public static void Insert(Integer num) {
        /* 插入要保证两个堆存于平衡状态 */
        if (N % 2 == 0) {
            /* N 为偶数的情况下插入到小数半边（大顶堆）。
             * 因为大顶堆元素都要大于小顶堆，但是新插入的元素不一定比大顶堆元素来的大，
             * 因此需要先将元素插入大顶堆，然后利用大顶堆的特点，取出堆顶元素即为最大元素，此时插入小顶堆 */
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        } else {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
        N++;
    }

    public static Double GetMedian() {
        if (N % 2 == 0) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return (double) minHeap.peek();
        }
    }

    public static void main(String[] args) {
        Insert(5);
        System.out.print(GetMedian());
        Insert(2);
        System.out.print(GetMedian());
        Insert(3);
        System.out.print(GetMedian());
    }
}
