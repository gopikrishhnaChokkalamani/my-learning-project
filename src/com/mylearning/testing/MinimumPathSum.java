package com.mylearning.testing;

public class MinimumPathSum {

  public static void main(String[] args) {
    int[][] arr = {
        {1, 3, 1},
        {1, 5, 1},
        {4, 2, 1}
    };
    System.out.println(minPathSum(arr, arr.length - 1, arr[0].length - 1));
  }

  private static int minPathSum(int[][] arr, int row, int col) {
    if (row < 0 || col < 0) {
      return Integer.MAX_VALUE;
    }
    if (row == 0 && col == 0) {
      return arr[row][col];
    }
    int up = minPathSum(arr, row - 1, col);
    int left = minPathSum(arr, row, col - 1);
    return arr[row][col] + Math.min(up, left);
  }
}
