package com.mylearning.testing;

import com.mylearning.problems.v1.leetcode.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrder {

  public static void main(String[] args) {
    TreeNode node = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
    List<List<Integer>> list = levelOrder(node);
  }

  private static List<List<Integer>> levelOrder(TreeNode node) {
    if (node == null) return null;

    List<List<Integer>> list = new ArrayList<>();
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(node);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> subList = new ArrayList<>();
      while (size --> 0) {
        TreeNode currNOde = queue.remove();
        subList.add(currNOde.val);
        if (currNOde.left != null) queue.add(currNOde.left);
        if (currNOde.right != null) queue.add(currNOde.right);
      }
      list.add(subList);
    }
    return list;
  }
}
