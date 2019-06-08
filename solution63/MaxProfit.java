package solution63;

import java.util.Arrays;

/**
 * 可以有一次买入和一次卖出，买入必须在前。求最大收益。
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 */
public class MaxProfit {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int[] res = new int[prices.length];
        for (int start = 0; start < prices.length; start++) {
            int max = Integer.MIN_VALUE;
            for (int end = start; end < prices.length; end++) {
                max = Math.max(max, prices[end] - prices[start]);

            }
            res[start] = max;
        }
        int ret = Integer.MIN_VALUE;
        for (int value : res) {
            ret = Math.max(ret, value);
        }
        return ret;
    }

    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int curMin = prices[0];
        int maxProfit = Integer.MIN_VALUE;
        for (int price : prices) {
            curMin = Math.min(curMin, price);
            maxProfit = Math.max(maxProfit, price - curMin);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.print(maxProfit(prices));
    }
}
