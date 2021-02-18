package com.mylearning.problems.v1.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
  
//  Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order
//  Example 1:
//  Input: nums = [1,2,3]
//  Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//  Example 2:
//  Input: nums = [0,1]
//  Output: [[0,1],[1,0]]
//  Example 3:
//  Input: nums = [1]
//  Output: [[1]]
  
  public static void main(String[] args) {
    int[] arr = {1, 2};
    List<List<Integer>> list = new ArrayList<>();
    generatePermutations(arr, list, 0);
    for (List<Integer> s : list) {
        System.out.println(s);
    }
  }
  
  private static void generatePermutations(int[] arr, List<List<Integer>> list, int start) {
    if (start == arr.length - 1) {
      List<Integer> inner = new ArrayList<>();
      for (Integer i : arr) {
        inner.add(i);
      }
      list.add(inner);
    }
    for (int i = start; i < arr.length; i++) {
      swap(arr, i, start);
      generatePermutations(arr, list, start + 1);
      swap(arr, i, start);
    }
  }
  
  private static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
