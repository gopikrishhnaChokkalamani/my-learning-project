package com.mylearning.problems.v1.leetcode.medium;

public class BestTimetoBuyAndSellStockwithCooldown {

  /*
  buy - (arr, i + 1, sum - arr[i], 1) - arr[i]
  sell - (arr, i + 2, sum + arr[i], 0) + arr[i];
  cooldown - (arr, i + 1, sum, pass)
   */

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 0, 2};
    Integer[][] dp =  new Integer[arr.length][2];
    System.out.println(maxProfit(arr, 0,  0, dp));

    //another way
    int sold = 0, hold = Integer.MIN_VALUE, rest = 0;
    for (int i = 0; i < arr.length; i++) {
      int prevSold = sold;
      sold = hold + arr[i];
      hold = Math.max(hold, rest - arr[i]);
      rest = Math.max(rest, prevSold);
    }
    System.out.println(Math.max(rest, sold));
  }

  private static int maxProfit(int[] arr, int i, int action, Integer[][] dp ) {
    if (i > arr.length - 1) return 0;

    if (dp[i][action] != null) {
      return dp[i][action];
    }
    int profit = 0;
    if (action == 0) {
      profit = maxProfit(arr, i + 1,  1, dp) - arr[i];
    } else if (action == 1) {
      profit = maxProfit(arr, i + 2,  0, dp) + arr[i];
    }
    dp[i][action] = Math.max(maxProfit(arr, i + 1, action, dp), profit);
    return dp[i][action];
  }
}