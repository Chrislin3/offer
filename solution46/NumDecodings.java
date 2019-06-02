package solution46;

/**
 * 给定一个数字，按照如下规则翻译成字符串：1 翻译成“a”，2 翻译成“b”... 26 翻译成“z”。
 * 一个数字有多种翻译可能，例如 12258 一共有 5 种，分别是 abbeh，lbeh，aveh，abyh，lyh。
 * 实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 分析：
 * 采用动态规划的方法来实现，dp数组存储着到该位置可以翻译的可能性个数
 * 若当前位置是i，首先看数组中该位置是不是0，
 * 如果不是0，他就可以单独出现，看dp[i-1]的可能性个数，给位置的值可以跟i-1的位置的值分别配对，即为dp[i-1]
 * 然后看数组i-1位置是不是0，如果是0，i位置不能和它配对了，只能单独出现
 * 如果是0，它不能单独出现，只能跟i-1位置配对，配对的值必须满足<=26才算配对成功，
 * 成功之后需要看dp[i-2]的可能性个数，配对的值可以跟i-2的位置的值分别配对，即为dp[i-2]
 * 总之，一共四种情况：
 * 1）该位置i是0，前一位置i-1是0，玩完了，毛都配不出来
 * 2）该位置i是0，前一位置i-1不是0，赶紧和i-1配，还得保证配完了<=26，否则还是玩完，dp[i] = dp[i-2]
 * 3）该位置i不是0，前一位置i-1是0，那你就单独玩吧，不要和i-1配了，只需要看dp[i-1]，dp[i] = dp[i-1]
 * 4）该位置i不是0，前一位置i-1不是0，这时既要自己，又要和i-1配对后看是否<=26，dp[i] = dp[i-1] + dp[i-2]
 */
public class NumDecodings {
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = chars[0] == '0' ? 0 : 1;
        for (int i = 1; i < len; i++) {
            if (chars[i] != '0') {
                dp[i + 1] += dp[i];
            }
            if (chars[i - 1] == '0') {
                continue;
            }
            if (Integer.valueOf(chars[i - 1] + "" + chars[i])<=26) {
                dp[i+1]+=dp[i-1];
            }
        }
        return dp[len];
    }
    public static void main(String[] args) {
        System.out.println(numDecodings("12258"));
    }

}
