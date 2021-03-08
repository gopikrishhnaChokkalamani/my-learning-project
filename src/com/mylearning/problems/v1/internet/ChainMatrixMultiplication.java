package com.mylearning.problems.v1.internet;

public class ChainMatrixMultiplication {

  public static void main(String[] args) {
    int[] p = {10, 30, 5, 60};
    int n = p.length;
    int[][] m = new int[n + 1][n + 1];
    int[][] s = new int[n + 1][n + 1];

    for (int d = 2; d < n; d++) {
      for (int i = 1; i <= n - d; i++) {
        int j = i + d - 1;
        int min = Integer.MAX_VALUE;
        for (int k = i; j < n && k <= j - 1; k++) {
          int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
          if (q < min) {
            min = q;
            s[i][j] = k;
          }
        }
        m[i][j] = min;
      }
    }
    System.out.println("Dynamic Programming - bottom up : " + m[1][n - 1] + " - " + s[1][n - 1]);
    int[][] dp = new int[n][n];
    System.out.println("Dynamic Programming - top down : " + topDown(p, 0, p.length - 1, dp));
  }

  private static int topDown(int[] p, int i, int j, int[][] dp) {
    if (j <= i + 1) {
      return 0;
    }

    int min = Integer.MAX_VALUE;

    if (dp[i][j] == 0) {
      for (int k = i + 1; k <= j - 1; k++) {
        int cost = topDown(p, i, k, dp);
        cost += topDown(p, k, j, dp);
        cost += p[i] * p[k] * p[j];
        if (cost < min) {
          min = cost;
        }
      }
      dp[i][j] = min;
    }
    return dp[i][j];
  }
}