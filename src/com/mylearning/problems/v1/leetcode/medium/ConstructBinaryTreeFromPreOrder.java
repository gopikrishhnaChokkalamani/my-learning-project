package com.mylearning.problems.v1.leetcode.medium;

import com.sun.source.tree.Tree;

public class ConstructBinaryTreeFromPreOrder {
  
  public static void main(String[] args) {
    int[] preorder = {8, 5, 1, 7, 10, 12};
    Contruct c = new Contruct();
    TreeNode node = c.construct(preorder);
    int i = 0;
  }
}

class Contruct {
  TreeNode root;
  
  public TreeNode construct(int[] preorder) {
    TreeNode node = null;
    for (int i = 0; i < preorder.length; i++) {
      node = construct(preorder[i], node);
    }
    return node;
  }
  
  private TreeNode construct(int data, TreeNode node) {
    if (node == null) {
      return new TreeNode(data);
    } else {
      return insert(node, data);
    }
  }
  
  private TreeNode insert(TreeNode node, int data) {
    if (node == null) {
      return new TreeNode(data);
    } else if (data < node.val) {
      node.left = insert(node.left, data);
    } else if (data > node.val) {
      node.right = insert(node.right, data);
    }
    return node;
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
