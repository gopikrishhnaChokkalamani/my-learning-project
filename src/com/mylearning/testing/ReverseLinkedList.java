package com.mylearning.testing;

import com.mylearning.problems.v1.leetcode.ListNode;

public class ReverseLinkedList {

  public static void main(String[] args) {
    ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    ListNode result = reverse(node);
    print(result);
  }

  private static void print(ListNode node) {
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.next;
    }
  }

  private static ListNode reverse(ListNode node) {
    ListNode prev = null, next = null;
    while (node != null) {
      next = node.next;
      node.next = prev;
      prev = node;
      node = next;
    }
    return prev;
  }
}
