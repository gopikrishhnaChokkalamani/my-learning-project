package com.mylearning.problems.v1.leetcode.medium;

public class IslandMaxArea {
  
  public static void main(String[] args) {
    int[][] arr = {
        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
    };
    int numOfLandArea = 0;
    int maxArea = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (arr[i][j] == 1) {
         // numOfLandArea += dfs(arr, i, j);
          maxArea = Math.max(maxArea, dfs(arr, i, j));
        }
      }
    }
    System.out.println(maxArea);
  }
  
  private static int dfs(int[][] arr, int i, int j) {
    if (i < 0 || i >= arr.length || j < 0 || j >= arr[i].length || arr[i][j] == 0) {
      return 0;
    }
    arr[i][j] = 0;
    return 1 + dfs(arr, i + 1, j) + dfs(arr, i - 1, j) + dfs(arr, i, j + 1) +  dfs(arr, i, j - 1);
  }
}
