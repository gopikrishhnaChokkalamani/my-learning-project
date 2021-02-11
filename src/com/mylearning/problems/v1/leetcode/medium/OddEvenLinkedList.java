package com.mylearning.problems.v1.leetcode.medium;

public class OddEvenLinkedList {
  //by position not value
  public static class ListNode {
    int val;
    ListNode next;
    
    ListNode() {
    }
    
    ListNode(int val) {
      this.val = val;
    }
    
    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
  
  public static void main(String[] args) {
    ListNode list = oddEvenList(new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(7))))))));
    while (list != null) {
      System.out.print(list.val + " -> ");
      list = list.next;
    }
    System.out.println();
   ListNode listNode = another(new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(7))))))));
    while (listNode != null) {
      System.out.print(listNode.val + " -> ");
      listNode = listNode.next;
    }
  }
  
  private static ListNode another(ListNode root) {
    if (root == null) {
      return root;
    }
    ListNode odd = root;
    ListNode even = root.next;
    ListNode evenTmp = even;
    while (even != null) {
      odd.next = even.next;
      odd = odd.next;
      even.next = odd.next;
      even = even.next;
    }
    odd.next = evenTmp;
    return root;
  }
  
  
  public static ListNode oddEvenList(ListNode root) {
    if (root == null) {
      return root;
    }
    ListNode odd = new ListNode(0), even = new ListNode(0);
    int i = 1;
    ListNode o = odd, e = even;
    while (root != null) {
      if (i % 2 == 0) {
        e.next = root;
        e = e.next;
      } else {
        o.next = root;
        o = o.next;
      }
      i++;
      root = root.next;
    }
    e.next = null;
    o.next = even.next;
    
    return odd.next;
  }
}
