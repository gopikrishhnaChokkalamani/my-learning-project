package com.mylearning.problems.v1.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SubSets {

  public static void main(String[] args) {
    int[] arr = {1, 2, 2};
    getSubSets(arr, 0, arr.length - 1, new ArrayList<>());
    System.out.println();
    for (List<Integer> l : list) {
      for (Integer i : l) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }

  static List<List<Integer>> list = new ArrayList<>();

  private static void getSubSets(int[] arr, int start, int end, List<Integer> subList) {
    //if (start >  end) return;
    list.add(new ArrayList<>(subList));
    for (int i = start; i < arr.length; i++) {
      if (i != start && arr[i] == arr[i - 1]) continue;
      subList.add(arr[i]);
      getSubSets(arr, i + 1, end, subList);
      subList.remove(subList.size() - 1);
    }
  }
}
