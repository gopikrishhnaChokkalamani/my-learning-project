package com.mylearning.problems.v1.leetcode.medium;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {

  public static void main(String[] args) {
    int arr[] = {2, 6, 4, 8, 10, 9, 15};
    System.out.println(findUnsortedSubarray(arr));
    System.out.println(find(arr));
    System.out.println(findAnother(arr));
  }

  public static int findUnsortedSubarray(int[] arr) {
    int[] sorted = arr.clone();
    Arrays.sort(sorted);
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(sorted));
    int start = arr.length, end = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != sorted[i]) {
        start = Math.min(start, i);
        end = Math.max(end, i);
      }
    }
    return end - start >= 0 ? end - start + 1 : 0;
  }

  public static int find(int[] arr) {
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] > arr[i + 1]) {
        min = Math.min(min, arr[i + 1]);
      }
    }

    for (int i = arr.length - 1; i > 0; i--) {
      if (arr[i] < arr[i - 1]) {
        max = Math.max(max, arr[i - 1]);
      }
    }

    int start = 0, end = 0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > min) {
        start = i;
        break;
      }
    }

    for (int i = arr.length - 1; i >= 0; i--) {
      if (arr[i] < max) {
        end = i;
        break;
      }
    }

    return end - start >= 0 ? end - start + 1 :0;
  }

  private static int findAnother(int[] arr) {
    //arr = new int[]{1, 3, 2, 4, 5};
    if (arr == null || arr.length == 0) return 0;
    //int i = 0, j = arr.length - 1;
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length - 1; i++) {
      min = Math.min(min, arr[i]);
    }

    for (int i = arr.length - 1; i > 0; i--) {
      max = Math.max(max, arr[i]);
    }

    int start = 0, end = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > min) {
        start = i;
        break;
      }
    }

    for (int i = arr.length - 1; i >= 0 ; i--) {
      if (arr[i] < max) {
        end = i;
        break;
      }
    }

    return end - start > 0 ? end - start + 1: 0;
  }
}