package solution58;

/**
 * Input:
 * S="abcXYZdef"
 * K=3
 * Output:
 * "XYZdefabc"
 */
public class LeftRotateString {
    public static String leftRotateString(String str,int n) {
        if (str == null || str.length() < 2) {
            return str;
        }
        char[] chars = str.toCharArray();
        reverseString(chars, 0, n - 1);
        reverseString(chars, n, chars.length - 1);
        reverseString(chars, 0, chars.length - 1);
        return String.valueOf(chars);
    }

    private static void reverseString(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.print(leftRotateString("abcXYZdef", 3));
    }
}
