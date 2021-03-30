package com.mylearning.testing;

import com.mylearning.problems.v1.leetcode.TreeNode;

public class InvertBinaryTree {

  public static void main(String[] args) {
    TreeNode node = invertTree(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9))));
    System.out.println();
  }

  private static TreeNode invertTree(TreeNode root) {
    if (root == null) return null;

    TreeNode leftSubTree = invertTree(root.left);
    TreeNode rightSubTree = invertTree(root.right);

    root.left = rightSubTree;
    root.right = leftSubTree;
    return root;
  }
}
