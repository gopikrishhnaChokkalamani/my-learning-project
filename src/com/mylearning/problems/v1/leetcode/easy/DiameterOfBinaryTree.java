package com.mylearning.problems.v1.leetcode.easy;

public class DiameterOfBinaryTree {
  
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
  
  static int max = 0;
  public static void main(String[] args) {  //
    int d = diameterOfBinaryTree(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3)));
    System.out.println(max == 0 ? max : max - 1);
  }
  
  public static int diameterOfBinaryTree(TreeNode node) {
    if (node == null) return 0;
    int left = diameterOfBinaryTree(node.left);
    int right = diameterOfBinaryTree(node.right);
    max = Math.max(max, left + right + 1);
    return Math.max(left, right) + 1;
  }
}
