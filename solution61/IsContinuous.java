package solution61;

import java.util.Arrays;

/**
 * 五张牌，其中大小鬼为癞子，牌面为 0。判断这五张牌是否能组成顺子。
 *
 */
public class IsContinuous {
    public static boolean isContinuous(int [] numbers) {
        if (numbers.length != 5) {
            return false;
        }
        Arrays.sort(numbers);
        int cnt = 0;
        // 统计癞子数量
        for (int number : numbers) {
            if (number == 0) {
                cnt++;
            }

        }
        // 使用癞子去补全不连续的顺子
        //注意i的起始位置，要去除开头的0
        for (int i = cnt + 1; i < numbers.length; i++) {
            if (numbers[i] == numbers[i - 1]) {
                return false;
            }
            cnt -= numbers[i] - numbers[i - 1] - 1;
        }
        return cnt >= 0;
    }
    public static void main(String[] args) {
        int[] n = {0,3,2,6,4};
        System.out.print(isContinuous(n));
    }
}
