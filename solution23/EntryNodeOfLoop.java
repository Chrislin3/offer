package solution23;
/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * <p>
 * x+z+2y = 2(x+y+z) ===>  x=z
 * 但是要注意快指针和慢指针在第一步是怎么走的
 */
/**
 * x+z+2y = 2(x+y+z) ===>  x=z
 * 但是要注意快指针和慢指针在第一步是怎么走的
 */

import solution6.ListNode;

public class EntryNodeOfLoop {
    public ListNode entryNodeOfLoop(ListNode pHead) {

        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode fastPoint = pHead.next.next;
        ListNode slowPoint = pHead.next;
        while (fastPoint != slowPoint) {
            if (fastPoint == null || fastPoint.next == null) {
                return null;
            }
            fastPoint = fastPoint.next.next;
            slowPoint = slowPoint.next;

        }
        while (pHead != slowPoint) {
            pHead = pHead.next;
            slowPoint = slowPoint.next;
        }
        return pHead;
    }
}
