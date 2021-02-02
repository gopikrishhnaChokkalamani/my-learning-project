package com.mylearning.problems.v1.leetcode.medium;

public class IslandsNumberOfClosed {
  
  public static void main(String[] args) {
    int[][] arr = {
        {1, 1, 1, 1, 1, 1, 1, 0},
        {1, 0, 0, 0, 0, 1, 1, 0},
        {1, 0, 1, 0, 1, 1, 1, 0},
        {1, 0, 0, 0, 0, 1, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 0}
    };
    int numOfIslands = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (arr[i][j] == 0) {
          numOfIslands += dfs(arr, i, j);
        }
      }
    }
    System.out.println(numOfIslands);
  }
  
  private static int dfs(int[][] arr, int i, int j) {
    if (i < 0 || i>= arr.length || j< 0 || j >= arr[i].length) {
      return 0;
    }
    if (arr[i][j] == 1) {
      return 1;
    }
    arr[i][j] = 1;
    int c1 = dfs(arr, i + 1, j);
    int c2 = dfs(arr, i - 1, j);
    int c3 = dfs(arr, i, j + 1);
    int c4 = dfs(arr, i, j - 1);
    if (c1 == 1 && c2 == 1 && c3 == 1 && c4 == 1) {
      return 1;
    }
    return 0;
  }
}
