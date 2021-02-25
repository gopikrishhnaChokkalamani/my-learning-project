package com.mylearning.problems.v1.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreePreOrderInOrder {
  
  public class TreeNode {
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
    int[] preOrder = {3,9,20,15,7};
    int[] inOrder = {9,3,15,20,7};
    ConstructBinaryTreePreOrderInOrder c = new ConstructBinaryTreePreOrderInOrder();
    TreeNode t = c.buildTree(preOrder, inOrder);
    int i = 0;
  }
  
  Map<Integer, Integer> map = new HashMap<>();
  int pIndex = 0;
  
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    return buildTree(preorder, 0, inorder.length - 1);
  }
  
  private TreeNode buildTree(int[] preorder, int i, int j) {
    if (i > j) return null;
    TreeNode node = new TreeNode(preorder[pIndex++]);
    
    if (node == null) return null;
    if (i == j) return node;
    int index = map.get(node.val); //find the root node index
    node.left = buildTree(preorder, i, index - 1);
    node.right = buildTree(preorder, index + 1, j);
    return node;
  }
}