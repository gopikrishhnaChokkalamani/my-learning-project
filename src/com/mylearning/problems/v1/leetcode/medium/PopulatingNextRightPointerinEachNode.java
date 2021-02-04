package com.mylearning.problems.v1.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointerinEachNode {
  
  static class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    
    public Node() {}
    
    public Node(int _val) {
      val = _val;
    }
    
    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }
  
  public static void main(String[] args) {
    Node node = new Node(1, new Node(2, new Node(4), new Node(5), null), new Node(3, new Node(6), new Node(7), null), null);
    Node newNode = connect(node);
    preOrder(node);
    System.out.println();
    postOrder(node);
    System.out.println();
    inOrder(node);
  }
  
  private static void inOrder(Node node) {
    if (node == null) return;
    inOrder(node.left);
    System.out.print(node.val + " ");
    inOrder(node.right);
  }
  
  private static void preOrder(Node node) {
    if (node == null) return;
    System.out.print(node.val + " ");
    preOrder(node.left);
    preOrder(node.right);
  }
  
  private static void postOrder(Node node) {
    if (node == null) return;
    postOrder(node.left);
    postOrder(node.right);
    System.out.print(node.val + " ");
  }
  
  private static Node connect(Node node) {
    if (node == null) return null;
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    queue.add(null);
    Node prevNode = null;
    //instead of using prevNode u can also use currNode.next = queue.peek();
    while (!queue.isEmpty()) {
      Node currNode = queue.remove();
      if (currNode == null && queue.isEmpty()) {
        return node;
      } else if (currNode == null) {
        prevNode.next = null;
        queue.add(null);
      } else {
        if (prevNode != null) {
          prevNode.next = currNode;
        }
        if (currNode.left != null) {
          queue.add(currNode.left);
        }
        if (currNode.right != null) {
          queue.add(currNode.right);
        }
      }
      prevNode = currNode;
    }
    return node;
  }
}
