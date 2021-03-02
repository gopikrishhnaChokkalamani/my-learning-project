package com.mylearning.problems.v1.leetcode.easy;

import java.util.Arrays;

public class MoveZeros {

  public static void main(String[] args) {
    int[] arr = {0, 1, 0, 3, 12};
    int n = arr.length - 1;

    //O(n^2)
//    for (int i = arr.length - 1; i >= 0; i--) {
//      if (arr[i] == 0) {
//        for (int j = i; j < n; j++) {
//          int tmp = arr[j];
//          arr[j] = arr[j + 1];
//          arr[j + 1] = tmp;
//        }
//        n = n - 1;
//      }
//    }

    //O(n)
    int j = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) {
        arr[j] = arr[i];
        if (i != j) arr[i] = 0;
        j++;
      }
    }
    System.out.println(Arrays.toString(arr));
  }
}
