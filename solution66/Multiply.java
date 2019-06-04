package solution66;

/**
 * 给定一个数组 A[0, 1,..., n-1]，
 * 请构建一个数组 B[0, 1,..., n-1]，其中 B 中的元素 B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 要求不能使用除法。
 * 分析：
 * 准备两个数组，一个数组用来计算从该位置的上一位置起，左边的所有数的乘积，另一个数组用来计算从该位置的下一位置起，右边所有数的乘积
 * 然后将两个数组对应位置的数相乘，就是我们需要的除了该位置其他的乘积
 * 例如数组[1，4，2，5，3]
 * 1左边默认是1，4左边就是1，2左边就是1*4=4，5左边就是4*2=8，3左边就是8*5=40；
 * 3右边默认是1，5右边就是3，2右边就是3*5=15，4右边就是15*2=30，1右边就是30*4=120
 * 所以，0位置=1*120=120，1位置=1*30=30，2位置=4*15=60，3位置=8*3=24，4位置=40*1=40
 */
public class Multiply {
    public static int[] multiply(int[] A) {
        int len = A.length;
        int[] leftToRight = new int[len];
        int[] rightToLeft = new int[len];
        leftToRight[0] = 1;
        rightToLeft[len - 1] = 1;
        int[] res = new int[len];
        for (int i = 1; i < len; i++) {
            leftToRight[i] = leftToRight[i - 1] * A[i - 1];
        }
        for (int j = len - 1; j > 0; j--) {
            rightToLeft[j - 1] = rightToLeft[j] * A[j];
        }
        for (int k = 0; k < len; k++) {
            res[k] = leftToRight[k] * rightToLeft[k];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

    }
}
