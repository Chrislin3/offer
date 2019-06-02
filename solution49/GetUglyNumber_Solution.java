package solution49;

/**
 * 把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。
 * 例如 6、8 都是丑数，但 14 不是，因为它包含因子 7。
 * 习惯上我们把 1 当做是第一个丑数。求按从小到大的顺序的第 N 个丑数。
 * 分析：将2，3，5当作比较的标准，第0个位置是1是确定的，就把第一个位置的数分别与2，3，5相乘，取最小的，
 * 取到谁就把和谁相乘呢个的数组索引向后移一位
 * 例如第一次肯定是取到2*res[0]，下一次和2相乘的会变成res[1]，而和3，5相乘的还是res[0]
 */
public class GetUglyNumber_Solution {
    public static int getUglyNumber_Solution(int index) {
        if (index < 1) {
            return 0;
        }
        int[] res = new int[index];
        res[0] = 1;
    //    res[1] = 2;
        int num_2 = 0;
        int num_3 = 0;
        int num_5 = 0;

        for (int i = 1; i < index; i++) {
            res[i] = Math.min(res[num_2] * 2, Math.min(res[num_3] * 3, res[num_5] * 5));
            if (res[i] == res[num_2] * 2) {
                num_2++;
            }
            if (res[i] == res[num_3] * 3) {
                num_3++;
            }
            if (res[i] == res[num_5] * 5) {
                num_5++;
            }
        }
        return res[index - 1];
    }
    public static void main(String[] args) {
        System.out.print(getUglyNumber_Solution(11));
    }
}
