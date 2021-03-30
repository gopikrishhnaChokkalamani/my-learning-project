package com.mylearning.testing;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3};
    permutations(arr,0, arr.length - 1);
    for (List<Integer> l : list) {
      for (Integer i : l) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }

  static List<List<Integer>> list = new ArrayList<>();

  private static void permutations(int[] arr, int start, int j) {
    if (start == j) {
      List<Integer> inner = new ArrayList<>();
      for (Integer a : arr) {
        inner.add(a);
      }
      list.add(inner);
    }
    for (int i = start; i < arr.length;i++) {
      swap(arr, i, start);
      permutations(arr, start + 1, j);
      swap(arr, i, start);
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int tmp = arr[j];
    arr[j] = arr[i];
    arr[i] = tmp;
  }
}
