package com.mylearning.problems.v1.leetcode.hard;

public class BurstBalloon {

  public static void main(String[] args) {
    int[] p = {3, 1, 5, 8};
    int n = p.length;
    int[][] m = new int[n][n];

    for (int d = 0; d < n; d++) {
      for (int i = 0; i + d < n; i++) {
        int j = i + d;
        for (int k = i; k <= j; k++) {
          //m[i][k] + m [k + 1][j] + p[i - 1] * p[k] * p[j];
          int leftNum = i == 0 ? 1 : p[i - 1];
          int rightNum = j == n - 1 ? 1 : p[j + 1];
          int left = k == i ? 0 : m[i][k -1];
          int right = k ==j ? 0 : m[k + 1][j];
          m[i][j] = Math.max(m[i][j], leftNum * p[k] * rightNum + left + right);
        }
      }
    }
    System.out.println(m[0][n - 1]);
  }
}
