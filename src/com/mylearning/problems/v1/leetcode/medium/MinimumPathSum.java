package com.mylearning.problems.v1.leetcode.medium;

public class MinimumPathSum {
  
  public static void main(String[] args) {
    int[][] grid = {
        {1, 3, 1},
        {1, 5, 1},
        {4, 2, 1}
    };
    Integer[][] dp = new Integer[grid.length + 1][grid.length + 1];
    System.out.println(minimumPathSum(grid, grid.length - 1, grid[0].length - 1, dp));
    System.out.println();
    System.out.println(minPathSum(grid));
  }
  
  private static int minimumPathSum(int[][] arr, int row, int col, Integer[][] dp) {
    if (row < 0 || col < 0) {
      return Integer.MAX_VALUE;
    }
    if (row == 0 && col == 0) {
      return arr[row][col];
    }
    if (dp[row][col] == null) {
      int right = minimumPathSum(arr, row, col - 1, dp);
      int down = minimumPathSum(arr, row - 1, col, dp);
      dp[row][col] = arr[row][col] + Math.min(right, down);
    }
    return dp[row][col];
  }

  public static int minPathSum(int[][] grid) {
    if (grid == null || grid.length == 0) return 0;
    int[][] arr = new int[grid.length + 1][grid[0].length + 1];

    for (int i = 2; i < arr.length; i++) {
      arr[i][0] = Integer.MAX_VALUE;
    }

    for (int i = 2; i < arr[0].length; i++) {
      arr[0][i] = Integer.MAX_VALUE;
    }

    for (int i = 1; i < arr.length; i++) {
      for (int j = 1; j < arr[0].length; j++) {
        arr[i][j] = grid[i - 1][j - 1] + Math.min(arr[i - 1][j], arr[i][j - 1]);
      }
    }
    return arr[grid.length][grid[0].length];
  }
}