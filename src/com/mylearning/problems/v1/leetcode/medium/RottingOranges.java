package com.mylearning.problems.v1.leetcode.medium;

public class RottingOranges {

  public static void main(String[] args) {
    int[][] arr = {
        {2, 1, 1},
        {1, 1, 0},
        {0, 1, 1}
    };

    System.out.println(find(arr));
  }

  private static int find(int[][] arr) {
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j <arr[i].length; j++) {
        if (arr[i][j] == 2) {
          rottingOrange(arr, i, j, 0, true);
        }
      }
    }
    int max = 0;
    for (int[] ints : arr) {
      for (int i : ints) {
        if (i == 1) return -1;
        max = Math.min(i, max);
      }
    }
    return -max;
  }

  private static void rottingOrange(int[][] arr, int i, int j, int dist, boolean start) {
    if (i < 0 || i >= arr.length || j < 0 || j >= arr[i].length || arr[i][j] == 0
        || arr[i][j] < 0 && -arr[i][j] < dist)
      return;

    if (arr[i][j] == 2 && !start) {
      return;
    }
    arr[i][j] = -dist;
    rottingOrange(arr, i + 1, j, dist + 1, false);
    rottingOrange(arr, i - 1, j, dist + 1, false);
    rottingOrange(arr, i, j + 1, dist + 1, false);
    rottingOrange(arr, i, j - 1, dist + 1, false);
  }
}
