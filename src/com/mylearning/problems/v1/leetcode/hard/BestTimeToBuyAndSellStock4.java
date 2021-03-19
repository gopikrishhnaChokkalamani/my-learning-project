package com.mylearning.problems.v1.leetcode.hard;

public class BestTimeToBuyAndSellStock4 {

  public static void main(String[] args) {
    int[] arr = {3, 2, 6, 5, 0, 3};
    int k = 2;

    int[][] trans = new int[k][2];
    for (int i = 0; i < k; i++) {
      trans[i][0] = Integer.MAX_VALUE;
    }
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < k; j++) {
        int prevProfit = 0;
        if (j > 0) prevProfit = trans[j - 1][1];
        trans[j][0] = Math.min(trans[j][0], arr[i] - prevProfit);
        trans[j][1] = Math.max(trans[j][1], arr[i] - trans[j][0]);
      }
    }
    System.out.println();
  }
}
