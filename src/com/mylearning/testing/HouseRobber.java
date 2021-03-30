package com.mylearning.testing;

public class HouseRobber {

  public static void main(String[] args) {
    int[] arr = {2,7,9,3,1};
    System.out.println(robHouse(arr, 0, arr.length - 1));
  }

  private static int robHouse(int[] arr, int i, int j) {
    if (i > j) return 0;
    return Math.max(arr[i] + robHouse(arr, i + 2, j), robHouse(arr, i + 1, j));
  }
}
