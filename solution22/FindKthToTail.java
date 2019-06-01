package solution22;

import solution6.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */

/**
 * 思路：
 * 设链表的长度为 N。设两个指针 P1 和 P2，先让 P1 移动 K 个节点，则还有 N - K 个节点可以移动。
 * 此时让 P1 和 P2 同时移动，可以知道当 P1 移动到链表结尾时，P2 移动到 N - K 个节点处，该位置就是倒数第 K 个节点。
 */
public class FindKthToTail {
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode cur1 = head;
        ListNode cur2 = head;
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        if (k > len) {
            return null;
        }
        while (k >= 1) {
            cur1 = cur1.next;
            k--;
        }
        while (cur1 != null) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur2;
    }
}
