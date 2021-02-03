package com.mylearning.problems.v1.leetcode.easy;

public class ClimbingStairs {
  
  public static void main(String[] args) {
    int n = 3;
    int[] dp = new int[n + 1];
    System.out.println(ways(n, dp));
    int[] tab = new int[n + 1];
    tab[0] = 1;
    tab[1] = 1;
    for (int i = 2; i <= n; i++) {
      tab[i] = tab[i - 1] + tab[i - 2];
    }
    int i = 0;
  }
  
  private static int ways(int n, int[] dp) {
    if (n < 1) return 0;
    if (n == 1) return 1;
    if (n == 2) return 2;
    if (dp[n] == 0) {
      dp[n] = ways(n - 1, dp) + ways(n - 2, dp);
    }
    return dp[n];
  }
}
