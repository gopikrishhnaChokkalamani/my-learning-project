package com.mylearning.testing;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

  public static void main(String[] args) {
    int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};

    int max = 0;
    int[] dp = new int[arr.length];
    Arrays.fill(dp, 1);
    for(int i = 1; i < arr.length; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
        max = Math.max(dp[i], max);
      }
    }
    System.out.println(max);
  }
}
