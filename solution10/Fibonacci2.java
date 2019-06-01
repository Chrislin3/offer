package solution10;

/**
 * 求斐波那契数列的第 n 项，n <= 39。
 */
//动态规划：
//把子问题的解缓存起来，从而避免重复求解子问题。
public class Fibonacci2 {
    public int Fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
}
