package solution10;

/**
 * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
 */
public class RectCover {
    public int RectCover(int target) {
        if (target <= 3) {
            return target;
        }

        int[] rect = new int[target + 1];

        rect[1] = 1;
        rect[2] = 2;
        rect[3] = 3;
        for (int i = 4; i <= target; i++) {
            rect[i] = rect[i - 1] + rect[i - 2];
        }
        return rect[target];
    }
}
