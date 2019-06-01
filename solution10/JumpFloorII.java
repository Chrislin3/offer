package solution10;

/**
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */
//思路：
//多列几项就会发现规律是什么
public class JumpFloorII {
    public int jumpFloorII(int target) {
        return (int) Math.pow(2, target - 1);
    }
}
