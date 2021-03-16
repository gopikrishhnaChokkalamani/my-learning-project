package com.mylearning.problems.v1.leetcode.medium;

import java.util.ArrayList;
import java.util.stream.Stream;

public class IntervalListIntersections {

  public static void main(String[] args) {
    int[][] first = {
        {0, 2},
        {5, 10},
        {13, 23},
        {24, 25}
    };

    int[][] second = {
        {1, 5},
        {8 , 12},
        {15, 24},
        {25, 26}
    };
    int[][] result = intervalIntersection(first, second);
    for (int[] r : result) {
      for (Integer i : r) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }

  private static int[][] intervalIntersection(int[][] first, int[][] second) {
    if (first == null || first.length == 0 && second == null || second.length == 0) return new int[0][];
    int i = 0, j = 0;
    ArrayList<int[]> list = new ArrayList<>();
    while (i < first.length && j < second.length) {
      int maxOfElement0 = Math.max(first[i][0], second[j][0]);
      int minOfElement1 = Math.min(first[i][1], second[j][1]);
      if (maxOfElement0 <= minOfElement1) {
        list.add(new int[]{maxOfElement0, minOfElement1});
      }
      if (first[i][1] < second[j][1]) i++;
      else j++;
    }
    return list.toArray(int[][]::new);
    //return ans.toArray(new int[ans.size()][]);
  }
}
