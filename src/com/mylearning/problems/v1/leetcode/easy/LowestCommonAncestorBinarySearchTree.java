package com.mylearning.problems.v1.leetcode.easy;

public class LowestCommonAncestorBinarySearchTree {

  public static void main(String[] args) {
    TreeNode result = lowestCommonAncestor(new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))),
        new TreeNode(8, new TreeNode(7), new TreeNode(9))), new TreeNode(2), new TreeNode(8));
    System.out.println();
  }

  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    int parentVal = root.val;
    int pVal = p.val;
    int qVal = q.val;

    if (pVal > parentVal && qVal > parentVal) {
      return lowestCommonAncestor(root.right, p, q);
    } else if (pVal < parentVal && qVal < parentVal) {
      return lowestCommonAncestor(root.left, p, q);
    } else {
      return root;
    }
  }

  //Iterative
  // Value of p
//  int pVal = p.val;
//
//  // Value of q;
//  int qVal = q.val;
//
//  // Start from the root node of the tree
//  TreeNode node = root;
//
//  // Traverse the tree
//        while (node != null) {
//
//    // Value of ancestor/parent node.
//    int parentVal = node.val;
//
//    if (pVal > parentVal && qVal > parentVal) {
//      // If both p and q are greater than parent
//      node = node.right;
//    } else if (pVal < parentVal && qVal < parentVal) {
//      // If both p and q are lesser than parent
//      node = node.left;
//    } else {
//      // We have found the split point, i.e. the LCA node.
//      return node;
//    }
//  }
//        return null;
}
