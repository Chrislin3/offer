package solution10;

/**
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */
public class JumpFloor {
    public int jumpFloor(int target) {
        if(target <= 2){
            return target;
        }
        int[] jump = new int[target + 1];
        jump[1] = 1;
        jump[2] = 2;
        for(int i = 3;i<=target;i++){
            jump[i] = jump[i-1] + jump[i-2];
        }
        return jump[target];
    }
}
