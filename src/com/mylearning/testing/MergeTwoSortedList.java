package com.mylearning.testing;

import com.mylearning.problems.v1.leetcode.ListNode;

public class MergeTwoSortedList {

  public static void main(String[] args) {
    ListNode node = mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))), new ListNode(1, new ListNode(3, new ListNode(4))));
  }

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode currL1 = l1;
    ListNode currL2 = l2;
    ListNode newNode = new ListNode(0);
    ListNode curr = newNode;
    while (currL1 != null && currL2 != null) {
      if (currL1.val < currL2.val) {
        curr.next = currL1;
        currL1 = currL1.next;
      } else {
        curr.next = currL2;
        currL2 = currL2.next;
      }
      curr = curr.next;
    }

    if (currL1 != null) {
      curr.next = currL1;
    }
    if (currL2 != null) {
      curr.next = currL2;
    }
    return newNode.next;
  }
}
