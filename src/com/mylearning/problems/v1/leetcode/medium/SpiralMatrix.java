package com.mylearning.problems.v1.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

  public static void main(String[] args) {
    int[][] arr = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    int m = arr.length;
    int n = arr[0].length;

    List<Integer> list = new ArrayList<>();
    int up = 0;
    int down = arr.length - 1;
    int left = 0;
    int right = arr[0].length - 1;

    while (list.size() != m * n) {

      for (int i = left; i <= right && list.size() != m * n; i++) {
        list.add(arr[up][i]);
      }

      for (int i = up + 1; i <= down && list.size() != m * n; i++) {
        list.add(arr[i][right]);
      }

      for (int i = right - 1; i >= left && list.size() != m * n; i--) {
        list.add(arr[down][i]);
      }

      for (int i = down - 1; i >= up + 1 && list.size() != m * n; i--) {
        list.add(arr[i][left]);
      }
      left++;
      up++;
      down--;
      right--;
    }
    System.out.println();
  }
}
