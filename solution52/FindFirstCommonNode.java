package solution52;
/**
 * 输入两个链表，找出它们的第一个公共结点。
 * 分析：
 * 第一种解法：计算两个链表的长度差，长的那个先把长的部分遍历完，之后两个一起跑，当跑到相同的节点时就返回
 * 第二种解法：设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
 *             当访问链表 A 的指针访问到链表尾部时，令它从链表 B 的头部重新开始访问链表 B；
 *             同样地，当访问链表 B 的指针访问到链表尾部时，令它从链表 A 的头部重新开始访问链表 A。
 *             这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
 */

import solution6.ListNode;

public class FindFirstCommonNode {
    public static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        int k = 0;
        while (cur1 != null) {
            k++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            k--;
            cur2 = cur2.next;
        }
        ListNode point1 = k > 0 ? pHead1 : pHead2;
        ListNode point2 = point1 == pHead1 ? pHead2 : pHead1;
        while (Math.abs(k) > 0) {
            point1 = point1.next;
            if (k > 0) {
                k--;
            } else {
                k++;
            }
        }
        while (point1 != point2 && point1 != null) {
            point1 = point1.next;
            point2 = point2.next;
        }
        return point1;
    }

    public static ListNode findFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        ListNode point1 = pHead1;
        ListNode point2 = pHead2;
        while (point1 != point2) {
            point1 = point1 == null ? pHead2 : point1.next;
            point2 = point2 == null ? pHead1 : point2.next;
        }
        return point1;

    }

    public static void main(String[] args) {
        ListNode pHead1 = new ListNode(1);
        pHead1.next = new ListNode(2);
        pHead1.next.next = new ListNode(3);
        pHead1.next.next.next = new ListNode(6);//交点
        pHead1.next.next.next.next = new ListNode(7);
  //      pHead1.next.next.next.next.next = new ListNode(6);

        ListNode pHead2 = new ListNode(4);
        pHead2.next = new ListNode(5);
    //    pHead2.next.next = new ListNode(9);
        pHead2.next.next = pHead1.next.next.next;
//        pHead2.next.next.next = new ListNode(10);
//        pHead2.next.next.next = pHead1.next.next.next;

        ListNode res = findFirstCommonNode(pHead1, pHead2);
        System.out.print(res.val);
    }
}
