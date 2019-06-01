package solution41;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
字符流中第一个不重复的字符
请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。
当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。
 */
public class FirstAppearingOnce {

    public static Queue<Character> queue = new LinkedList<>();
    public static  Map<Character, Integer> map = new HashMap<>();
    //Insert one char from stringstream
    public static void Insert(char ch)
    {
        queue.add(ch);
        if (map.containsKey(ch)) {
            int value = map.get(ch);
            map.put(ch, value+1);
        } else {
            map.put(ch, 1);
        }
    }
    //return the first appearence once char in current stringstream
    public static char firstAppearingOnce() {
        while (!queue.isEmpty() && map.get(queue.peek()) > 1) {
            queue.poll();
        }
        if (queue.isEmpty()) {
            return '#';
        } else {
            return queue.peek();
        }
    }

    public static void main(String[] args) {
        Insert('h');
        System.out.print(firstAppearingOnce());
        Insert('e');
        System.out.print(firstAppearingOnce());
        Insert('l');
        System.out.print(firstAppearingOnce());
        Insert('l');
        System.out.print(firstAppearingOnce());
        Insert('o');
        System.out.print(firstAppearingOnce());
        Insert('w');
        System.out.print(firstAppearingOnce());
        Insert('o');
        System.out.print(firstAppearingOnce());
        Insert('r');
        System.out.print(firstAppearingOnce());
        Insert('l');
        System.out.print(firstAppearingOnce());
        Insert('d');
        System.out.print(firstAppearingOnce());
    }
}
