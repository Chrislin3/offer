package test;

import org.junit.Test;
import solution10.RectCover;
import solution12.HasPath;
import solution18.DeleteDuplication;
import solution18.DeleteNode;
import solution23.EntryNodeOfLoop;
import solution26.TreeNode;
import solution27.Mirror;
import solution30.MinStack;
import solution31.IsPopOrder;
import solution34.FindPath;
import solution5.ReplaceSpace;
import solution6.ListNode;
import solution6.PrintListFromTailToHead;

import java.util.ArrayList;

public class Main {
//    public static void main(String[] args) {
////        StringBuffer str = new StringBuffer("hello w orld");
////        ReplaceSpace rs = new ReplaceSpace();
////
////        System.out.println(rs.replaceSpace(str));
////        ListNode listNode = new ListNode(1);
////        listNode.next = new ListNode(2);
////        listNode.next.next = new ListNode(3);
////
////        PrintListFromTailToHead pftt = new PrintListFromTailToHead();
////        ArrayList<Integer> arr = new ArrayList<Integer>();
////        arr = pftt.printListFromTailToHead(listNode);
////        System.out.println(arr.toString());
////        RectCover rc = new RectCover();
////        rc.RectCover(1);
////        HasPath hp = new HasPath();
////        char[] arr = {'a','b','t','g','c','f','c','s'};
////        char[] str = {'c','f','c'};
////
////        System.out.println(hp.hasPath(arr,2,2,str));
////        ListNode head = new ListNode(1);
////        head.next = new ListNode(2);
////        head.next.next = new ListNode(3);
////        head.next.next.next = new ListNode(4);
////        head.next.next.next.next = new ListNode(5);
////        head.next.next.next.next.next = head.next.next;
////
////        EntryNodeOfLoop entrynodeofloop = new EntryNodeOfLoop();
////        entrynodeofloop.entryNodeOfLoop(head);
//////        DeleteDuplication deleteNode = new DeleteDuplication();
//////        deleteNode.deleteDuplication(head);
//////        System.out.println(head);
////        System.out.println("000");
////        TreeNode root = new TreeNode(1);
////////        root.left = new TreeNode(2);
////////        root.right = new TreeNode(3);
////////        root.left.left = new TreeNode(4);
////////        root.left.right = new TreeNode(5);
////////        root.right.left = new TreeNode(6);
////////
////////        Mirror mirror = new Mirror();
////////        mirror.bianli(root);
//        MinStack ms = new MinStack();
//        ms.push(3);
//        System.out.println(ms.min());
//        ms.push(4);
//        System.out.println(ms.min());
//        ms.push(2);
//        System.out.println(ms.min());
//        ms.push(3);
//        System.out.println(ms.min());
//        ms.pop();
//        System.out.println(ms.min());
//        ms.pop();
//        System.out.println(ms.min());
//        ms.pop();
//        System.out.println(ms.min());
//        ms.push(0);
//        System.out.println(ms.min());
//    }
    @Test
    public void test31(){
        int[] pushA = {1,2,3,4,5};
        int[] pushB = {4,5,3,2,1};
        IsPopOrder isPopOrder = new IsPopOrder();
        System.out.println(isPopOrder.isPopOrder(pushA,pushB));

    }
    @Test
    public void test34(){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);

        FindPath findPath = new FindPath();
        findPath.findPath(root,22);
    }

}
