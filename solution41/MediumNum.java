package solution41;

import java.util.PriorityQueue;

public class MediumNum {
    public static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    public static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public static int maxSize = 0;
    public static int minSize = 0;

    public static void Insert(Integer num) {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            maxHeap.add(num);
            maxSize++;
        } else if (maxHeap.isEmpty()) {
            maxHeap.add(num);
            maxSize++;
        } else if (minHeap.isEmpty()) {
            minHeap.add(num);
            minSize++;

        } else {
            if (num < maxHeap.peek()) {
                maxHeap.add(num);
                maxSize++;
            }
            else if (num > minHeap.peek()) {
                minHeap.add(num);
                minSize++;
            }
            if (Math.abs(minSize - maxSize) == 2) {
                if (maxSize > minSize) {
                    minHeap.add(maxHeap.poll());
                    minSize++;
                    maxSize--;
                } else {
                    maxHeap.add(minHeap.poll());
                    minSize--;
                    maxSize++;
                }
            }

        }
    }

    public static Double GetMedian() {
        if (maxSize > minSize) {
            return Double.valueOf(maxHeap.peek());
        } else if (minSize > maxSize) {
            return Double.valueOf(minHeap.peek());
        } else {
            return (Double.valueOf(maxHeap.peek()) + Double.valueOf(minHeap.peek())) / 2;
        }
    }

    public static void main(String[] args) {
        Insert(5);
        Insert(2);
        Insert(3);


        System.out.print(GetMedian());
    }
}
