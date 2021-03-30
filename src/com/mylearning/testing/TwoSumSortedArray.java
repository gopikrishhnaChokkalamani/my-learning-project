package com.mylearning.testing;

import java.util.Arrays;

public class TwoSumSortedArray {

  public static void main(String[] args) {
    int[] arr = {2,3,4};
    int[] result = extracted(arr);
    System.out.println(Arrays.toString(result));
  }

  private static int[] extracted(int[] arr) {
    int i = 0, j = arr.length - 1, t = 6;
    while (i < j) {
      if (arr[i] + arr[j] == t) return new int[]{i + 1, j + 1};
      else if (arr[i] + arr[j] < t) i++;
      else j--;
    }
    return null;
  }
}