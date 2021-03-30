package com.mylearning.testing;

import com.mylearning.problems.v1.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {

  public static void main(String[] args) {
    TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5), null), new TreeNode(3, new TreeNode(6), new TreeNode(7), null), null);
    //TreeNode result = connect(node);
    print(node);
  }

  private static TreeNode connect(TreeNode node) {
    if (node == null) return null;
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(node);
    while (!queue.isEmpty()) {
      int size = queue.size();
      TreeNode prevNode = null;
      while (size --> 0) {
        TreeNode currNode = queue.remove();
        if (prevNode != null) prevNode.next = currNode;
        if (currNode.left != null) queue.add(currNode.left);
        if (currNode.right != null) queue.add(currNode.right);
        prevNode = currNode;
      }
    }
    return node;
  }

  private static TreeNode print(TreeNode node) {
    if (node == null) return null;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(node);
    //int space = 32;
    while (!queue.isEmpty()) {
      int size = queue.size();
      //TreeNode prevNode = null;
      while (size --> 0) {
        TreeNode currNode = queue.remove();
        System.out.print(currNode.val);
        //if (prevNode != null) prevNode.next = currNode;
        if (currNode.left != null) queue.add(currNode.left);
        if (currNode.right != null) queue.add(currNode.right);
        //prevNode = currNode;
      }
      System.out.println();
    }
    return node;
  }
}