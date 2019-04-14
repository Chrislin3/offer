package solution11;

/**题目：
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 *
 * 例如数组 {3, 4, 5, 1, 2} 为 {1, 2, 3, 4, 5} 的一个旋转，该数组的最小值为 1。
 */

/**思路：
 * 在一个有序数组中查找一个元素可以用二分查找，二分查找也称为折半查找，每次都能将查找区间减半，
 * 这种折半特性的算法时间复杂度都为 O(logN)。
 *
 * 本题可以修改二分查找算法进行求解。
 * 这里要注意的是，由于数组不是排好顺序的，所以，在进行if判断的时候要分析清楚，
 * 因为整体是递增的，所以如果array[mid] >= array[high]，说明min一定在右半部分，
 * 但是，如果是array[mid] >= array[low]，我们是无法确保min在哪一边的
 *
 * 还有一个要注意的点：
 * 如果数组元素允许重复的话，那么就会出现一个特殊的情况：array[l] == array[m] == array[h]，
 * 此时无法确定解在哪个区间，需要切换到顺序查找。
 * 例如对于数组 {1,1,1,0,1}，l、m 和 h 指向的数都为 1，此时无法知道最小数字 0 在哪个区间。
 */
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        int low = 0;
        int high = array.length - 1;

        while (low < high){
            int mid = low +( high - low)/2;
            if(!(!(array[low] == array[mid]) || !(array[mid] == array[high]))){
                return minNumber(array, low, high);
            }
            if(array[mid] >= array[high]){
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return array[high];
    }
    private int minNumber(int[] array, int low, int high){
        int min = array[low];
        for (int i = low;i< high;i++){
            if(array[i] < min){
                min = array[i];
            }
        }
        return min;
    }
}
