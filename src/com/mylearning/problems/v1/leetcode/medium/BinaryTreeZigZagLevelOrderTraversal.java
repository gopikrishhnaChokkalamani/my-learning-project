package com.mylearning.problems.v1.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigZagLevelOrderTraversal {

  public static void main(String[] args) {
    TreeNode node = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
    List<List<Integer>> nodes = zigzagLevelOrder(node);
  }

  public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) return Collections.emptyList();

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    //queue.add(null);
    boolean even = true;
    List<List<Integer>> main = new ArrayList<>();
    while(!queue.isEmpty()) {
      int size = queue.size();
      LinkedList<Integer> list = new LinkedList<>();
      for (int i = 0; i < size; i++) {
        TreeNode curr = queue.remove();
        if (curr.left != null) queue.add(curr.left);
        if (curr.right != null) queue.add(curr.right);
        if (even) list.add(curr.val);
        else list.addFirst(curr.val);
      }
      main.add(list);
      even = !even;
    }
    return main;
  }
}
