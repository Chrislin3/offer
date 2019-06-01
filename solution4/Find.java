package solution4;

/**
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。
 * 给定一个数，判断这个数是否在该二维数组中。
 */
public class Find {
    public boolean find(int target, int[][] array) {
        if ((array == null || array.length == 0) || (array.length == 1 && array[0].length == 0)) { //
            return false;
        }
        int row = array.length;
        int col = array[0].length;

        int i = 0;
        int j = col - 1;
        while (array[i][j] != target) {
            if (array[i][j] < target) {
                i++;
                if (i >= row) {
                    return false;
                }
            } else {
                j--;
                if (j < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
