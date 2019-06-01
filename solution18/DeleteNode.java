package solution18;

import solution6.ListNode;

/**
 * 题目：
 * 在 O(1) 时间内删除链表节点
 */

/**思路：
 * （1）如果该节点不是尾节点，那么可以直接将下一个节点的值赋给该节点，然
 *      后令该节点指向下下个节点，再删除下一个节点，时间复杂度为 O(1)。
 * （2）否则，就需要先遍历链表，找到节点的前一个节点，然后让前一个节点指向 null，时间复杂度为 O(N)。
 */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if (head == null) {
            return null;
        }
        if (tobeDelete.next != null) {
            tobeDelete.val = tobeDelete.next.val;
            tobeDelete.next = tobeDelete.next.next;
        } else {
            if (head.next == tobeDelete) {
                return head;
            } else {
                ListNode cur = head;
                while (cur != null) {
                    if (cur.next == tobeDelete) {
                        cur.next = null;
                    }
                    cur = cur.next;
                }
                return head;
            }
        }
        return head;
    }
}
