package com.mylearning.problems.v1.leetcode.medium;

public class RangeSum2DImmutable {
  
  public static void main(String[] args) {
    int[][] matrix = {
        {3, 0, 1, 4, 2},
        {5, 6, 3, 2, 1},
        {1, 2, 0, 1, 5},
        {4, 1, 0, 1, 7},
        {1, 0, 3, 0, 5}
    };
    NumMatrix m = new NumMatrix(matrix);
    m.print();
    System.out.println(m.sumRegion(2, 1, 4, 3));
  }
  
  static class NumMatrix {
    
    int[][] arr;
    
    public NumMatrix(int[][] matrix) {
      int rows = matrix.length;
      int cols = matrix[0].length;
      this.arr = new int[rows + 1][cols + 1];
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          arr[i + 1][j + 1] = matrix[i][j] + arr[i][j + 1] + arr[i + 1][j] - arr[i][j];
        }
      }
//      for (int i = matrix.length - 1; i >= 0; i--) {
//        for (int j = matrix[0].length - 1; j >= 0; j--) {
//          int k = 0;
//         // arr[i][j] = matrix[i][j] + Math.max((i == rows ? 0 : arr[i + 1][j]), (j == cols ? 0 : arr[i][j + 1]));
//        }
//      }
    }
    
    public void print() {
      for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[0].length; j++) {
          System.out.print(arr[i][j] > 9 ? arr[i][j] + " " : arr[i][j] + "  ");
        }
        System.out.println();
      }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
      System.out.println("arr[row2 + 1][col2 + 1] " + arr[row2 + 1][col2 + 1]);
      System.out.println("arr[row2 + 1][col1] " + arr[row2 + 1][col1]);
      System.out.println("arr[row1][col2 + 1] " + arr[row1][col2 + 1]);
      System.out.println("arr[row1][col1] " + arr[row1][col1]);
      return arr[row2 + 1][col2 + 1] - arr[row2 + 1][col1] - arr[row1][col2 + 1] + arr[row1][col1];
//      int sum = 0;
//      for (int i = row1; i <= row2; i++) {
//        for (int j = col1; j <= col2; j++) {
//          sum += arr[i][j];
//        }
//      }
//      return sum;
    }
  }
}
