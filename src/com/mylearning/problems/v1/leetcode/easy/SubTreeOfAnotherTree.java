package com.mylearning.problems.v1.leetcode.easy;


public class SubTreeOfAnotherTree {

  public static void main(String[] args) {
    TreeNode s = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
    TreeNode t = new TreeNode(4, new TreeNode(1), new TreeNode(2));
    System.out.println(isSubtree(s, t));
  }

  public static boolean isSubtree(TreeNode s, TreeNode t) {
    if (t == null) return true;
    if (s == null) return false;
    return isValidSubTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
  }

  public static boolean isValidSubTree(TreeNode s, TreeNode t) {
    if (t == null) return s == null;
    if (s == null) return t == null;
    if (s.val != t.val) return false;
    return isValidSubTree(s.left, t.left) && isValidSubTree(s.right, t.right);
  }
}
