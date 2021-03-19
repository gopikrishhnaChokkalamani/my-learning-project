package com.mylearning.problems.v1.leetcode.easy;

public class BestTimeToBuyAndSellStock {

  //best day to buy and best day to sell
  public static void main(String[] args) {
    int[] arr = {7, 1, 5, 3, 6, 4};
    int minPrice = Integer.MAX_VALUE;
    int profit = 0;
    for (int i = 0; i < arr.length; i++) {
      if (minPrice > arr[i]) minPrice = arr[i];
      else profit = Math.max(profit, arr[i] - minPrice);
    }
    System.out.println(profit);
  }
}
