package com.mylearning.testing;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

  public static void main(String[] args) {
    int[] arr = {1, 1, 2};
    int n = arr.length;
    int j = 0;
    System.out.println(Arrays.toString(arr));
    for (int i = 0; i < n; i++) {
      if (i < n - 1 && arr[i] == arr[i + 1]) continue;
      arr[j] = arr[i];
      j++;
    }
    System.out.println(Arrays.toString(arr));
    System.out.println(j);
  }
}
