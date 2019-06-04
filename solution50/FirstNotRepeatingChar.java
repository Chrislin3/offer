package solution50;

import java.util.HashMap;

public class FirstNotRepeatingChar {
    public static int firstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        HashMap<Character, Integer> map = new HashMap<>();
     //   Queue<Character> queue = new LinkedList<>();
        char[] chars = str.toCharArray();
        for (char chr : chars) {
      //      queue.add(chr);
            if (map.containsKey(chr)) {
                int value = map.get(chr);
                map.put(chr, value + 1);
            } else {
                map.put(chr, 1);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }

//        while (!queue.isEmpty()) {
//            char value = queue.peek();
//            if (map.get(value) == 1) {
//                return value;
//            } else {
//                queue.poll();
//            }
//        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.print(firstNotRepeatingChar("google"));
    }
}
