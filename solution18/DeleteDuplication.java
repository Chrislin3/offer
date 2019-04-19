package solution18;

import solution6.ListNode;

/**题目：
 *删除链表中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null){
            return null;
        }
        ListNode cur = pHead;
        while (cur != null){
            if(cur.val == cur.next.val){
                if(cur.next.next != null){
                    cur.next = null;
                }
                else {
                    cur.val = cur.next.next.val;
                    cur.next.val = cur.next.next.val;
                    cur.next = cur.next.next.next;
                    cur.next.next = cur.next.next.next.next;
                }

            }
            cur = cur.next;
        }
        return pHead;
    }
}
