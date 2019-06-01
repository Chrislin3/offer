package solution5;

/**
 * 将一个字符串中的空格替换成 "%20"。
 */
//首先计算新的字符串的长度 = 原长度 + 2 * 空格长度。将新字符串用空格填满，
// 之后用两个指针，第一个指针指向原串的尾部，第二个指针指向新串的尾部，
// 判断指针1（index1）是否为空，若为空，则指针2（index2）依次填充0、2、%，若不为空，则指针2（index2）填充index1指向的值。
public class ReplaceSpace {

    public String replaceSpace(StringBuffer str) {
        int length = str.length();
        int blankNum = 0;
        char[] arr = str.toString().toCharArray();
        for (char c : arr) {
            if (c == ' ') {
                blankNum++;
            }
        }
        int lengthTotal = length + 2 * blankNum;
        for (int i = length; i < lengthTotal; i++) {
            str.insert(i, ' ');
        }
        int index2 = lengthTotal - 1;
        for (int index1 = length - 1; index1 >= 0; index1--) {

            if (str.charAt(index1) == ' ') {
                str.setCharAt(index2--, '0');
                str.setCharAt(index2--, '2');
                str.setCharAt(index2--, '%');

            } else {
                str.setCharAt(index2--, str.charAt(index1));
            }

        }
        return str.toString();
    }
}
