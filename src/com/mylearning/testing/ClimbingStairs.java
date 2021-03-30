package com.mylearning.testing;

public class ClimbingStairs {

  public static void main(String[] args) {
    int n = 4;
    System.out.println(climbingStairs(n));
    //dp - bottom up
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i < dp.length; i++) {
      dp[i] = dp[i - 2] + dp[i - 1];
    }
    System.out.println(dp[n]);

  }

  private static int climbingStairs(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    if (n == 2) return 2;
    return climbingStairs(n - 1) + climbingStairs(n - 2);
  }
}
