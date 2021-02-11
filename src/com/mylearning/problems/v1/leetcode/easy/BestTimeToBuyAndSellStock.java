package com.mylearning.problems.v1.leetcode.easy;

public class BestTimeToBuyAndSellStock {
  
  public static void main(String[] args) {
    int[] arr = {7, 1, 5, 3, 6, 4};
    int minPrice = Integer.MAX_VALUE;
    int profit = 0;
    for (int i = 0; i < arr.length; i++) {
      if (minPrice > arr[i]) {
        minPrice = arr[i];
      } else if (arr[i] - minPrice > profit) {
        profit = arr[i] - minPrice;
      }
    }
  }
}
