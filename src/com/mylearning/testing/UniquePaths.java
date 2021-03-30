package com.mylearning.testing;

public class UniquePaths {

  public static void main(String[] args) {
    int m = 3, n = 7;
    int[][] arr = new int[m][n];
    System.out.println(uniquePaths(arr, arr.length - 1, arr[0].length - 1));
  }

  private static int uniquePaths(int[][] arr, int row, int col) {
    if (row < 0 || col < 0) {
      return 0;
    }
    if (row == 0 && col == 0) {
      return 1;
    }
    int left = uniquePaths(arr, row - 1, col);
    int up = uniquePaths(arr, row, col - 1);
    return left + up;
  }
}