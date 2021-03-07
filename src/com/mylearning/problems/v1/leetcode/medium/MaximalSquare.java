package com.mylearning.problems.v1.leetcode.medium;

public class MaximalSquare {

  public static void main(String[] args) {
    int[][] arr = {
        {1, 0, 1, 0, 0},
        {1, 0, 1, 1, 1},
        {1, 1, 1, 1, 1},
        {1, 0, 0, 1, 0}
    };
//    int[][] arr = {
//        {0, 1},
//        {1, 0}
//    };
    int[][] matrix = new int[arr.length][arr[0].length];
    //System.out.println(maximalSquare(arr, arr.length - 1, arr[0].length - 1));
    int max = 0;
    for (int i = 0; i < matrix.length; i++) {
      matrix[i][0] = arr[i][0];
      //max = Math.max(max, matrix[i][0]);
    }

    for (int i = 0; i < matrix[0].length;i++) {
      matrix[0][i] = arr[0][i];
      //max = Math.max(max, matrix[0][i]);
    }

    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (arr[i][j] == 1) {
          matrix[i][j] = Math.min(Math.min(matrix[i][j - 1], matrix[i - 1][j]), matrix[i - 1][j - 1]) + 1;
          max = Math.max(max, matrix[i][j]);
        }
      }
    }

    System.out.println(max * max);


    //if find max suare matrix, use below, above is find max suare matrix and then sum the values inside that
//    int maxSize = 0;
//    for (int i = 0; i < row; i++) {
//      for (int j = 0; j < cols; j++) {
//        if (sub[i][j] > maxSize) {
//          maxSize = sub[i][j];
//        }
//      }
//    }

    int i = 0;
  }

  static int max = 0;

  //this solution is maximal sub saure matrix
//  private static int maximalSquare(int[][] arr, int rows, int cols) {
//    //if (rows < 0 || rows > arr.length - 1 || cols < 0 || cols > arr[0].length - 1) {
//    if (rows < 0 || cols < 0) {
//      return 0;
//    }
//    int right = maximalSquare(arr, rows, cols - 1);
//    int down = maximalSquare(arr, rows - 1, cols);
//    int diagonal = maximalSquare(arr, rows - 1, cols - 1);
//    return (arr[rows][cols] == 1) ? Math.min(right, Math.min(down, diagonal)) + 1 : Math.min(right, Math.min(down, diagonal));
//    //return Math.min(right, Math.min(down, diagonal)) + 1;
//  }
}
