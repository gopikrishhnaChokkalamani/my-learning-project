package com.mylearning.testing;

import com.mylearning.problems.v1.leetcode.ListNode;

public class PalindromeLinkedList {

  public static void main(String[] args) {
    System.out.println(isPalindrome(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))))));
  }

  private static boolean isPalindrome(ListNode root) {
    ListNode fp = root, sp = root;
    while (fp != null && fp.next != null) {
      sp = sp.next;
      fp = fp.next.next;
    }

    ListNode mid = null;
    if (fp == null) {
      mid = sp;
    } else {
      mid = sp.next;
    }

    ListNode prev = null, next = null;
    while (mid != null) {
      next = mid.next;
      mid.next = prev;
      prev = mid;
      mid = next;
    }

    while (prev != null) {
      if (prev.val != root.val) {
        return false;
      }
      prev = prev.next;
      root = root.next;
    }
    return true;
  }
}
