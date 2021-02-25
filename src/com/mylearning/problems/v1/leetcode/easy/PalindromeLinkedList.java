package com.mylearning.problems.v1.leetcode.easy;

public class PalindromeLinkedList {
  
  public static void main(String[] args) {
    PalindromeLinkedList l = new PalindromeLinkedList();
    System.out.println(l.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))))));
    reverse(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1))))));
    System.out.println(l.isPalindrome1(new ListNode(0, new ListNode(0))));
  }
  
  private boolean isPalindrome1(ListNode root) {
    ListNode tmp = new ListNode();
    tmp = root;
    ListNode currNode = tmp;
    ListNode prev = null, next = null;
    while (currNode != null) {
      next = currNode.next;
      currNode.next = prev;
      prev = currNode;
      currNode = next;
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
  
  private static void reverse(ListNode root) {
    ListNode currNode = root;
    ListNode prev = null, next = null;
    while (currNode != null) {
      next = currNode.next;
      currNode.next = prev;
      prev = currNode;
      currNode = next;
    }
    int i = 0;
  }
  
  public boolean isPalindrome(ListNode root) {
    ListNode fp = root, sp = root, mid = null;
    while (fp != null && fp.next != null) {
      sp = sp.next;
      fp = fp.next.next;
    }
    
    if (fp != null) {
      mid = sp.next;
    } else {
      mid = sp;
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

class ListNode {
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
