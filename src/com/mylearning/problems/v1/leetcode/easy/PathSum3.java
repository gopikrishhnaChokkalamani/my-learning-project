package com.mylearning.problems.v1.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PathSum3 {

  public static void main(String[] args) {
    pathSum(new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(3),
        new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))), new TreeNode(-3, null,
        new TreeNode(11))), 8);
    System.out.println(count);
  }

  static int count = 0;
  static List<Integer> list = new ArrayList<>();
  public static void pathSum(TreeNode root, int sum) {
    if (root == null) return;
    list.add(root.val);
    pathSum(root.left, sum);
    pathSum(root.right, sum);

    int tmp = 0;
    for (int i = list.size() - 1; i >= 0; i--) {
      tmp += list.get(i);
      if (tmp == sum) {
        count++;
      }
    }
    list.remove(list.size() - 1);
  }
}