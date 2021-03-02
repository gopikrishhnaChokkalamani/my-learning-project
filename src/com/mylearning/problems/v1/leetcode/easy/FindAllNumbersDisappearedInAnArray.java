package com.mylearning.problems.v1.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {

  public static void main(String[] args) {
    int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
    List<Integer> list = extracted(arr);
  }

  private static List<Integer> extracted(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int tmp = Math.abs(arr[i]);
      arr[tmp - 1] = - Math.abs(arr[tmp - 1]);
    }
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > 0) result.add(i + 1);
    }

    return result;
  }
}