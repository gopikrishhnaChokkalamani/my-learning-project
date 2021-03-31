package com.mylearning.problems.v1.leetcode.medium;

public class SearchA2DMatrix {

  public static void main(String[] args) {
    int[][] arr = {
        {1, 3, 5, 7},
        {10, 11, 16, 20},
        {23, 30, 34, 60}
    };
    int t = 30;
    System.out.println(solve(arr, t));
    //
    System.out.println(anotherway(arr, t));
    //
    System.out.println(anotherway1(arr, t));
  }

  //O(n)
  private static boolean anotherway1(int[][] arr, int t) {
    int j = arr[0].length - 1, i = 0;
    while (i <= arr.length - 1  && j >= 0) {
      if (arr[i][j] == t) return true;
      if (t < arr[i][j]) {
        j--;
      } else {
        i++;
      }
    }
    return false;
  }

  //but O(m + n)
  private static boolean solve(int[][] arr, int t) {
    for (int[] a : arr) {
      if (a[0] == t) return true;
      if (a[0] < t) {
        for (Integer i : a) {
          if (i == t) return true;
        }
      }
    }
    return false;
  }

  // O(m + logN)
  private static boolean anotherway(int[][] arr, int t) {
    for (int[] a : arr) {
      if (a[0] == t) return true;
      if (a[0] < t && binarySearch(a, 0, a.length -1, t)) return true;
    }
    return false;
  }

  private static boolean binarySearch(int[] a, int start, int end, int t) {
    if (start > end) {
      return false;
    }
    int center = (start + end) / 2;
    if (a[center] == t) return true;
    else if (a[center] < t) return binarySearch(a, center + 1, end, t);
    else return binarySearch(a, start, center - 1, t);
  }
}
