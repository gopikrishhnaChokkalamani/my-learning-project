package com.mylearning.problems.v1.leetcode.medium;

public class Node {

  public int val;
  public int key;
  public Node next;
  public Node prev;
  public Node random;

  public Node(int key, int val) {
    this.key = key;
    this.val = val;
  }

  public Node(int val) {
    this.val = val;
  }
}
