package com.mylearning.testing;

import com.mylearning.problems.v1.leetcode.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedList {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1, new ListNode(4,new ListNode(5)));
    ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
    ListNode l3 = new ListNode(2, new ListNode(6));
    ListNode result = mergeKLists(new ListNode[]{l1, l2, l3});
    while (result != null) {
      System.out.print(result.val + " ");
      result = result.next;
    }
  }

  public static ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) return null;
    Queue<Integer> queue = new PriorityQueue<>();
    for (ListNode l : lists) {
      ListNode node = l;
      while (node != null) {
        queue.add(node.val);
        node = node.next;
      }
    }
    ListNode result = new ListNode(0);
    ListNode curr = result;
    while (!queue.isEmpty()) {
      curr.next = new ListNode(queue.remove());
      curr = curr.next;
    }
    return result.next;
  }
}
