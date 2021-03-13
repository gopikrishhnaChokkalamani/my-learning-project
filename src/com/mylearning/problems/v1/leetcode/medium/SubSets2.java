package com.mylearning.problems.v1.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets2 {

  public static void main(String[] args) {
    int[] arr = {1, 2, 2};
    Arrays.sort(arr);
    subSets(arr, new ArrayList<>(), 0);
    for (List<Integer> sub : list) {
      for (Integer i : sub) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }

  static List<List<Integer>> list = new ArrayList<>();

  private static void subSets(int[] arr, List<Integer> sub, int begin) {
    list.add(new ArrayList<>(sub));

    for (int i = begin; i < arr.length; i++) {
      if (i != begin && arr[i] == arr[i - 1]) {
        continue;
      }
      sub.add(arr[i]);
      subSets(arr, sub, i + 1);
      sub.remove(sub.size() - 1);
    }
  }
}
