package com.mylearning.problems.v1.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class CoinChange {
  
  public static void main(String[] args) {
    int[] coins = {1, 2, 5};
    int amount = 4;
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 0; i < coins.length; i++) {
      for (int j = coins[i]; j <= amount; j++) {
        dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
      }
    }
    System.out.println(dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount]);
    System.out.println(coinChange(coins, amount, new int[amount]));
  }
  
  private static int coinChange(int[] coins, int rem, int[] count) {
    if (rem < 0) return -1;
    if (rem == 0) return 0;
    if (count[rem - 1] != 0) return count[rem - 1];
    int min = Integer.MAX_VALUE;
    for (int coin : coins) {
      int res = coinChange(coins, rem - coin, count);
      if (res >= 0 && res < min)
        min = 1 + res;
    }
    count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
    return count[rem - 1];
  }
}
