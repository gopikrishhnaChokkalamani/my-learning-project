package com.mylearning.testing;

import com.mylearning.problems.v1.leetcode.TreeNode;

public class SymmetricTree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(3)), new TreeNode(2, new TreeNode(3), new TreeNode(4)));
    System.out.println(isSymmetric(root, root));
  }

  private static boolean isSymmetric(TreeNode left, TreeNode right) {
    if (left == null && right == null) return true;
    if (left == null || right == null) return false;
    return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
  }
}
