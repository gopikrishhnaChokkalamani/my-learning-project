package com.mylearning.problems.v1.leetcode.medium;

public class IslandShortestBridge {
  
  public static void main(String[] args) {
    int[][] arr = {
        {0, 1},
        {1, 0}
    };
    int num = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (arr[i][j] == 1) {
          System.out.println(dfs(arr, i , j));
         // num = Math.min(num, dfs(arr, i, j));
        }
      }
    }
    System.out.println(num);
    
  }
  
  private static int dfs(int[][] arr, int i, int j) {
    if (i < 0 || i > arr.length || j < 0 || j >= arr[i].length) {
      return 0;
    }
    if (arr[i][j] == 0) {
      return 1;
    }
    arr[i][j] = 1;
    int c1 = dfs(arr, i + 1, j);
    int c2 = dfs(arr, i - 1, j);
    int c3 = dfs(arr, i, j + 1);
    int c4 = dfs(arr, i, j - 1);
    return Math.min(Math.min(c1, Math.min(c2, c3)), c4);
  }
}
