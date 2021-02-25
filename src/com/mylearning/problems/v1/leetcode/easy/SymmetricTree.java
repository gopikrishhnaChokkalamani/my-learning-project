package com.mylearning.problems.v1.leetcode.easy;

public class SymmetricTree {
  
  public static void main(String[] args) {
    SymmetricTree s = new SymmetricTree();
    System.out.println(s.isSymmetric(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(3)), new TreeNode(2, new TreeNode(3), new TreeNode(4)))));
  }
  
  public boolean isSymmetric(TreeNode root) {
    return isSymmetric(root, root);
  }
  
  private boolean isSymmetric(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) return true;
    if (root1 == null || root2 == null) return false;
    return (root1.val == root2.val) && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
  }
}

class TreeNode {
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
