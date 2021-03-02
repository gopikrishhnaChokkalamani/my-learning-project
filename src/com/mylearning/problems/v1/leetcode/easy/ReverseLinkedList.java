package com.mylearning.problems.v1.leetcode.easy;

public class ReverseLinkedList {

  public static void main(String[] args) {
    ListNode node = reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
    int i = 0;
  }

  public static ListNode reverseList(ListNode root) {
    ListNode prev = null, next = null;
    ListNode curr = root;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }
}
