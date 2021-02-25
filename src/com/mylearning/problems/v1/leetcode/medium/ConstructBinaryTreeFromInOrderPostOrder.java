package com.mylearning.problems.v1.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInOrderPostOrder {
  
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
    int[] inorder = {9, 3, 15, 20, 7};
    int[] postorder = {9, 15, 7, 20, 3};
    ConstructBinaryTreeFromInOrderPostOrder c = new ConstructBinaryTreeFromInOrderPostOrder();
    TreeNode t = c.buildTree(inorder, postorder);
    int i = 0;
  }
  
  Map<Integer, Integer> map = new HashMap<>();
  
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    //pIndex = postorder.length - 1;
    return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
  }
  
  private TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int pStart, int pEnd) {
    if (inStart > inEnd) return null;
    TreeNode node = new TreeNode(postorder[pEnd]);
    if (node == null) return null;
    if (inStart == inEnd) return node;
    int index = map.get(node.val);
    node.left = buildTree(inorder, postorder, inStart, index - 1, pStart, pStart - inStart + index - 1);
    node.right = buildTree(inorder, postorder, index + 1, inEnd, pEnd - inEnd + index, pEnd - 1);
    return node;
  }
}
