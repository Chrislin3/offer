package solution62;

/**
 * 让小朋友们围成一个大圈。然后，随机指定一个数 m，让编号为 0 的小朋友开始报数。
 * 每次喊到 m-1 的那个小朋友要出列唱首歌，然后可以在礼品箱中任意的挑选礼物，并且不再回到圈中，
 * 从他的下一个小朋友开始，继续 0...m-1 报数 .... 这样下去 .... 直到剩下最后一个小朋友，可以不用表演。
 *
 * 约瑟夫环，圆圈长度为 n 的解可以看成长度为 n-1 的解再加上报数的长度 m。因为是圆圈，所以最后需要对 n 取余。
 */
public class LastRemaining_Solution {
    public static int lastRemaining_Solution(int n, int m) {
        if (n == 1) {
            return 0;
        }
        return (lastRemaining_Solution(n-1,m) + m) % n;
    }

    public static void main(String[] args) {
        System.out.print(lastRemaining_Solution(5, 2));
    }
}
