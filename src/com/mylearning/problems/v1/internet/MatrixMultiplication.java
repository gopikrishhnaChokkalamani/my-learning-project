package com.mylearning.problems.v1.internet;

public class MatrixMultiplication {

  public static void main(String[] args) {
    int[][] m = {
        {1, 2, 3},
        {4, 5, 6}
    };

    int[][] n = {
        {1, 2},
        {3, 4},
        {5, 6}
    };

    int[][] result = new int[m.length][n[0].length];

    int sum = 0;
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < n[0].length; j++) {
        for (int k = 0; k < n.length; k++) {
          sum += m[i][k] * n[k][i];
        }
        result[i][j] = sum;
        sum = 0;
      }
    }

    for (int[] i : result) {
      for (int j : i) {
        System.out.print(j + " ");
      }
      System.out.println();
    }
  }
}
