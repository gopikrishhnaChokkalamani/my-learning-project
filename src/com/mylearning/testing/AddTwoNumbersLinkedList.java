package com.mylearning.testing;

import com.mylearning.problems.v1.leetcode.ListNode;

public class AddTwoNumbersLinkedList {

  public static void main(String[] args) {
    ListNode node = addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))), new ListNode(5, new ListNode(6, new ListNode(8))));
  }

  public static ListNode addTwoNumbers(ListNode currL1, ListNode currL2) {
    int carry = 0;
    ListNode curr = new ListNode(0);
    ListNode tmp = curr;
    while(currL1 != null || currL2 != null) {
      int sum = carry;
      if (currL1 != null) {
        sum += currL1.val;
        currL1 = currL1.next;
      }
      if (currL2 != null) {
        sum += currL2.val;
        currL2 = currL2.next;
      }
      tmp.next = new ListNode(sum % 10);
      tmp = tmp.next;
      carry = sum / 10;
    }
    if (carry != 0) tmp.next = new ListNode(carry);
    return curr.next;
  }
}
