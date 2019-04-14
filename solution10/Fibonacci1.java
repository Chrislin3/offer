package solution10;

/**
 * 求斐波那契数列的第 n 项，n <= 39。
 */
//递归：
// 会重复计算一些子问题。例如，计算 f(10) 需要计算 f(9) 和 f(8)，计算 f(9) 需要计算 f(8) 和 f(7)，可以看到 f(8) 被重复计算了。
public class Fibonacci1 {
    public int Fibonacci(int n) {
        if(n <= 1){
            return n;
        }
        else {
            return Fibonacci(n-1) + Fibonacci(n-2);
        }
    }
}
