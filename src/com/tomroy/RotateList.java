package com.tomroy;


/**
 * Created by tom_th_lin on 2015/5/26.
 */
public class RotateList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *      int val;
     *      ListNode next;
     *      ListNode(int x) { val = x; }
     * }
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        head = head.next;
        return head;
    }

    public static void Switch(ListNode n){
        int tmp;
        ListNode sec = n.next;
        if(n.next != null) {
            n.next = n.next.next;
            sec.next = n;
        }
    }


    public static void main(String[] args){

        // given  1->2->3->4->5->NULL and k=2
        // return 4->5->1->2->3->NULL.

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        //ListNode n = rotateRight(head,2);
//        printListNodes(head);

        ListNode A = new ListNode(2);
        A.next = new ListNode(5);
        printListNodes(A);
        Switch(A);
        printListNodes(A);
    }

    public static void printListNodes(ListNode node) {
        if(node.next != null) {
            System.out.print(node.val + "->");
            printListNodes(node.next);
        }
        else
            System.out.println(node.val + "->NULL");
    }

}
