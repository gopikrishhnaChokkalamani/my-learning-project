package com.mylearning.problems.v1.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class NonOverlappingIntervals {

  public static void main(String[] args) {
    int[][] arr = {
        {1, 2},
        {2, 3},
        {3, 4},
        {1, 3}
    };

    Arrays.sort(arr, Comparator.comparingInt(ints -> ints[0]));
    LinkedList<int[]> list = new LinkedList<>();
    list.add(arr[0]);
    for (int i = 1; i < arr.length; i++) {
      int[] prev = list.getLast();
      int[] curr = arr[i];
      if (prev[1] > curr[0]) {
        prev[1] = Math.min(prev[1], curr[1]);
        list.removeLast();
        list.addLast(prev);
      } else {
        list.add(curr);
      }
    }
    System.out.println(arr.length - list.size());
    another(arr);
  }

  private static void another(int[][] arr) {
    Arrays.sort(arr, Comparator.comparingInt(ints -> ints[0]));
    int end = arr[0][1];
    int result = 0;
    for (int i = 1; i < arr.length; i++) {
      if (end > arr[i][0]) {
        end = Math.min(end, arr[i][1]);
        result++;
      } else {
        end = arr[i][1];
      }
    }
    System.out.println(result);
  }
}
