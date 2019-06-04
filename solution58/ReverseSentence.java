package solution58;

/**
 * Input:
 * "I am a student."
 * Output:
 * "student. a am I"
 * 假设符号^H代表字符反转，有公式(X^H Y^H)^H = YX
 * 所以对于字符串 I am a student."
 * 先依次反转每一个单词 I -> I; am -> ma; a -> a; student. -> .tnedust
 * 最后整体做一个反转 就得到结果：student. a am I
 */
public class ReverseSentence {
    public static String reverseSentence(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }

        char[] chars = str.toCharArray();
        int start = 0;
        int end = 0;
        for (int i = 0; i < chars.length; i++) {
            if (start == chars.length) {
                break;
            }
            //这里注意单词结尾不仅可能是空格前一字符，也可能是字符串最后一个字符哦
            if (chars[i] == ' ' || i == chars.length - 1) {
                end = i == chars.length - 1 ? chars.length - 1 : i - 1;
                reverseWord(chars, start, end);
                start = i + 1;
            }

        }
        reverseWord(chars, 0, chars.length - 1);
        return String.valueOf(chars);
    }

    private static void reverseWord(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }

    }
    public static void main(String[] args) {
        System.out.print(reverseSentence("I am a student."));
    }

}
