package com.mylearning.problems.v1.leetcode.medium;

public class UniquePaths {
  
  public static void main(String[] args) {
    uniquePaths(3, 7);
  }
  
  private static void uniquePaths(int rows, int cols) {
    int[][] arr = new int[rows][cols];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = -1;
      }
    }
    
    System.out.println(uniquePaths(arr, rows - 1, cols - 1));
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
    tabulation(rows, cols);
  }
  
  private static int uniquePaths(int[][] arr, int rows, int cols) {
    if (rows < 0 || cols < 0) {
      return 0;
    }
    if (rows == 0 && cols == 0) {
      arr[rows][cols] = 1;
      return 1;
    }
    if (arr[rows][cols] == -1) {
      arr[rows][cols] = uniquePaths(arr, rows - 1, cols) + uniquePaths(arr, rows, cols - 1);
    }
    return arr[rows][cols];
  }
  
  private static void tabulation(int row, int col) {
    int[][] arr = new int[row][col];
    
    for (int i = 0; i < row; i++) {
      arr[i][0] = 1;
    }
    
    for (int i = 0; i < col; i++) {
      arr[0][i] = 1;
    }
    
    for (int i = 1; i < row; i++) {
      for (int j = 1; j < col; j++) {
        arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
      }
    }
    System.out.println(arr[row - 1][col - 1]);
    
  }
}
