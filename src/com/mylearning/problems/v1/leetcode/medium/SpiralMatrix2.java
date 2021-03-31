package com.mylearning.problems.v1.leetcode.medium;

public class SpiralMatrix2 {

  public static void main(String[] args) {
    int n = 3;
    int[][] arr = new int[n][n];

    int left = 0;
    int down = n - 1;
    int up = 0;
    int right = n - 1;

    int k = 1;
    int index = 0;
    while (index != n * n) {

      // left to right
      for (int i = left; i <= right && index != n * n; i++) {
        arr[up][i] = k++;
        index++;
      }

      //top to bottom
      for (int i = up + 1; i <= down && index != n * n;i++ ) {
        arr[i][right] = k++;
        index++;
      }

      //right to left
      for (int i = right - 1; i >= left && index != n *n; i--) {
        arr[down][i] = k++;
        index++;
      }

      //bottom to top
      for (int i = down - 1; i >= up + 1 && index != n * n; i--) {
        arr[i][left] = k++;
        index++;
      }
      left++;
      up++;
      down--;
      right--;
    }
    System.out.println();
  }
}
