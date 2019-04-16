package test;

import solution10.RectCover;
import solution12.HasPath;
import solution5.ReplaceSpace;
import solution6.ListNode;
import solution6.PrintListFromTailToHead;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        StringBuffer str = new StringBuffer("hello w orld");
//        ReplaceSpace rs = new ReplaceSpace();
//
//        System.out.println(rs.replaceSpace(str));
//        ListNode listNode = new ListNode(1);
//        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(3);
//
//        PrintListFromTailToHead pftt = new PrintListFromTailToHead();
//        ArrayList<Integer> arr = new ArrayList<Integer>();
//        arr = pftt.printListFromTailToHead(listNode);
//        System.out.println(arr.toString());
//        RectCover rc = new RectCover();
//        rc.RectCover(1);
        HasPath hp = new HasPath();
        char[] arr = {'a','b','t','g','c','f','c','s'};
        char[] str = {'c','f','c'};

        System.out.println(hp.hasPath(arr,2,2,str));
    }
}
