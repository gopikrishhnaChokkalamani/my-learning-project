package com.mylearning.problems.v1.leetcode.medium;

import java.util.Arrays;

public class LongestIncreasingSubSequence {
  // array - {0, 3, 1, 6, 2, 2, 7}
  //subset - 3, 6, 2, 7 - can the numbers from the above array, order does not matter
  //sub array - 3, 1, 6, 2 - has to be in the same order
  //subsequence - 0, 1, 2, 7 - can be any numbers from the above array, but order has to be same
  public static void main(String[] args) {
    //int[] arr = {0, 3, 1, 6, 2, 2, 7};
    int[] arr = {0,1,0,3,2,3};
    System.out.println(lis(arr, 0, 1, arr.length - 1));
    int[] dp = new int[arr.length];
    Arrays.fill(dp, 1);
    int max = -1;
    for (int i = 1; i < arr.length; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      max = Math.max(dp[i], max);
    }
    System.out.println(max);
    int i = 0;
  }
  
  private static int lis(int[] arr, int i, int j, int k) {
    if (i >= k || j >= k) {
      return 0;
    }
    int case1 = 0;
    if (arr[i] < arr[j]) {
      int remaining = k - j;
      if (remaining == lis(arr, i, j + 1, k)) {
        case1 = 2;
      }
      //case1 = 2 + lis(arr, i + 2, j + 2, k);
    }
    int case3 = lis(arr, i + 1, j + 1, k);
    return Math.max(case1, case3);
  }
}