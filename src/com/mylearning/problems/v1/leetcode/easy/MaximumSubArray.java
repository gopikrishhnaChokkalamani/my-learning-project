package com.mylearning.problems.v1.leetcode.easy;

public class MaximumSubArray {

  public static void main(String[] args) {
    int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

    int totalMax = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      int max = 0;
      for (int j = i; j < arr.length; j++) {
        max += arr[j];
        totalMax = Math.max(max, totalMax);
      }
    }
    System.out.println(totalMax);
    dynamicProgramming(arr);
  }

  private static void dynamicProgramming(int[] arr) {
    int currMax = arr[0];
    int totalMax = arr[0];

    for (int i  = 1; i < arr.length; i++) {
      int tmp = arr[i];
      currMax = Math.max(tmp, tmp + currMax);
      totalMax = Math.max(totalMax, currMax);
    }
    System.out.println(totalMax);
  }
}
