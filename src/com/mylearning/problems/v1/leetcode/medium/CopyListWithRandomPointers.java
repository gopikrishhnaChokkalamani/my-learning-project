package com.mylearning.problems.v1.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointers {

  public static void main(String[] args) {
    Node node = new Node(7);
    Node node2 = new Node(13);
    Node node3 = new Node(11);
    Node node4 = new Node(10);
    Node node5 = new Node(1);

    node.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;

    node2.random = node;
    node3.random = node5;
    node4.random = node3;
    node5.random = node;

    Node result = copyRandomList(node);
    System.out.println();
  }

  private static Node copyRandomList(Node node) {
    Node curr = node;
    Map<Node, Node> map = new HashMap<>();
    while (curr != null) {
      map.put(curr, new Node(curr.val)); // new node creation, reference broken
      curr = curr.next;
    }

    curr = node;
    while (curr != null) {
      map.get(curr).next = map.get(curr.next);
      map.get(curr).random = map.get(curr.random);
      curr = curr.next;
    }
    return map.get(node);
  }
}
