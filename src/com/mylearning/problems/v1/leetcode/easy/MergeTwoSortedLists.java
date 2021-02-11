package com.mylearning.problems.v1.leetcode.easy;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeTwoSortedLists {
  
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
    ListNode l = mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))), new ListNode(1, new ListNode(3, new ListNode(4))));
    ListNode l1 = mergeTwoListsAnotherMethod(new ListNode(1, new ListNode(2, new ListNode(4))), new ListNode(1, new ListNode(3, new ListNode(4))));
    int i = 0;
  }
  
  private static ListNode mergeTwoListsAnotherMethod(ListNode listNode, ListNode listNode2) {
    Queue<Integer> queue = new PriorityQueue<>();
    ListNode l1 = listNode;
    while (l1 != null) {
      queue.add(l1.val);
      l1 = l1.next;
    }
    ListNode l2 = listNode2;
    while (l2 != null) {
      queue.add(l2.val);
      l2 = l2.next;
    }
    ListNode l = new ListNode(0);
    ListNode n = l;
    while (!queue.isEmpty()) {
      n.next = new ListNode(queue.remove());
      n = n.next;
    }
    return l.next;
  }
  
  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode curr = new ListNode(0);
    ListNode tmp = curr;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        tmp.next = new ListNode(l1.val);
        tmp = tmp.next;
        l1 = l1.next;
      } else {
        tmp.next = new ListNode(l2.val);
        tmp = tmp.next;
        l2 = l2.next;
      }
    }
    while (l2 != null) {
      tmp.next = new ListNode(l2.val);
      tmp = tmp.next;
      l2 = l2.next;
    }
    while (l1 != null) {
      tmp.next = new ListNode(l1.val);
      tmp = tmp.next;
      l1 = l1.next;
    }
    return curr.next;
  }
}
