package com.mylearning.testing;

import java.util.Arrays;

public class RemoveElement {

  public static void main(String[] args) {
    int[] arr = {3, 2, 2, 3};
    int n = arr.length, t = 3, j = 0;
    System.out.println(Arrays.toString(arr));
    for (int i = 0; i < n; i++) {
      if (t == arr[i]) {
        continue;
      }
      arr[j] = arr[i];
        j++;
    }
    System.out.println(Arrays.toString(arr));
    System.out.println(j);
  }
}
