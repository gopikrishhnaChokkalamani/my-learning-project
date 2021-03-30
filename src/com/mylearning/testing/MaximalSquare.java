package com.mylearning.testing;

public class MaximalSquare {

  public static void main(String[] args) {
    int[][] matrix = {
        {1, 0, 1, 0, 0},
        {1, 0, 1, 1, 1},
        {1, 1, 1, 1, 1},
        {1, 0, 0, 1, 0}
    };

    int[][] arr = new int[matrix.length + 1][matrix[0].length + 1];

//    for (int i = 0; i < matrix.length; i++) {
//      for (int j = 0; j < matrix[i].length; j++ ) {
//        arr[i][j] = matrix[i][j];
//      }
//    }
    int max = 0;
    for (int i = 1; i < arr.length; i++) {
      for (int j = 1; j < arr[0].length; j++) {
        if (matrix[i - 1][j - 1] == 1) {
          arr[i][j] = Math.min(arr[i][j - 1], Math.min(arr[i - 1][j], arr[i - 1][j - 1])) + 1;
          max = Math.max(max, arr[i][j]);
        }
      }
    }
    System.out.println(max * max);
  }
}
