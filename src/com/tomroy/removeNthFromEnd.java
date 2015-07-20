package com.tomroy;

import java.util.HashMap;

/**
 * Created by tom_th_lin on 2015/7/17.
 *
 <br>Given a linked list, remove the nth node from the end of list and return its head.
 <br>
 <br>For example,
 <br>
 <br>Given linked list: 1->2->3->4->5, and n = 2.
 <br>
 <br>After removing the second node from the end, the linked list becomes 1->2->3->5.
 <br>Note:
 <br>Given n will always be valid.
 <br>Try to do this in one pass.
 */
public class removeNthFromEnd {

//  Definition for singly-linked list.
  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
    }
  }

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    HashMap<Integer, ListNode> map = new HashMap<>();
    ListNode currentNode = head;
    int index = 1;
    while(currentNode != null){
      map.put(index,currentNode);
      currentNode = currentNode.next;
      index++;
    }
    if(map.size() == n) {
      return map.get(2);
    }
    ListNode nthPrevNode = map.get(map.size() - n);
//    ListNode nthNode = map.get(map.size() - n + 1);
    ListNode nthNextNode = nthPrevNode.next.next;
    nthPrevNode.next = nthNextNode;

    return head;
  }

  public static void main(String[] args) {

    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    printHead(head);
    head = removeNthFromEnd(head, 3);
    printHead(head);
  }

  private static void printHead(ListNode head) {
    ListNode currentNode = head;
    while(currentNode != null){
      if(currentNode.next != null)
        System.out.print(currentNode.val + "->");
      else
        System.out.println(currentNode.val);
      currentNode = currentNode.next;
    }
  }


}
