package com.mylearning.testing;

import com.mylearning.problems.v1.leetcode.TreeNode;

public class ValidateBinarySearchTree {

  public static void main(String[] args) {
    System.out.println(isValidBst(new TreeNode(3, new TreeNode(2), new TreeNode(1)), Integer.MIN_VALUE, Integer.MAX_VALUE));
  }

  private static boolean isValidBst(TreeNode node, int min, int max) {
    if (node == null) return true;
    if (node.val < min || node.val > max) {
      return false;
    }
    return isValidBst(node.left, min, node.val) && isValidBst(node.right, node.val, max);
  }
}
