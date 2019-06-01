package solution42;
/*
连续子数组的最大和
{6, -3, -2, 7, -15, 1, 2, 2}，连续子数组的最大和为 8（从第 0 个开始，到第 3 个为止）。
 */
public class FindGreatestSumOfSubArray {
    public static int findGreatestSumOfSubArray(int[] array) {
        if (array == null) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int value : array) {
            sum = sum >= 0 ? sum + value : value;
            max = Math.max(sum, max);
        }
        return max;
    }
}
