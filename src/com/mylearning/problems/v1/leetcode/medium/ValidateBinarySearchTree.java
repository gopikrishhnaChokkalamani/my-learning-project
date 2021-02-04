package com.mylearning.problems.v1.leetcode.medium;

public class ValidateBinarySearchTree {
  
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {
    }
    
    TreeNode(int val) {
      this.val = val;
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
  
  public static void main(String[] args) {
    TreeNode node = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
    boolean isBST = isBST(node, null, null);
    System.out.println(isBST);
    preOrder(node);
    System.out.println();
    postOrder(node);
    System.out.println();
    inOrder(node);
  }
  
  private static void inOrder(TreeNode node) {
    if (node == null) return;
    inOrder(node.left);
    System.out.print(node.val + " ");
    inOrder(node.right);
  }
  
  private static void preOrder(TreeNode node) {
    if (node == null) return;
    System.out.print(node.val + " ");
    preOrder(node.left);
    preOrder(node.right);
  }
  
  private static void postOrder(TreeNode node) {
    if (node == null) return;
    postOrder(node.left);
    postOrder(node.right);
    System.out.print(node.val + " ");
  }
  
  public static boolean isBST(TreeNode node, Integer min, Integer max) {
    if (node == null) {
      return true;
    }
    if ((min != null && node.val <= min)  || (max != null && node.val >= max)){
      return false;
    }
    return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
  }
}
