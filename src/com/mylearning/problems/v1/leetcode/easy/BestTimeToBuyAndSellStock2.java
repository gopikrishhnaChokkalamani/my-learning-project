package com.mylearning.problems.v1.leetcode.easy;

public class BestTimeToBuyAndSellStock2 {

  //wats the max profit you can make,  -> buy sell, buy sell, buy sell
  public static void main(String[] args) {
    int[] arr = {7, 1, 5, 3, 6, 4};
    int profit = 0;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] - arr[i - 1] > 0) {
        profit += arr[i] - arr[i - 1];
      }
    }
    System.out.println(profit);
  }
}
