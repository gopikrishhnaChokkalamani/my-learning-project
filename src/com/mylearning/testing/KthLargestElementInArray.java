package com.mylearning.testing;

import java.util.Arrays;

public class KthLargestElementInArray {

  public static void main(String[] args) {
    int[] arr = {3,2,1,5,6,4};
    Arrays.sort(arr);
    int k = 2;
    int element = 0;
    int j = arr.length - 1;
    while (k --> 0) {
      element = arr[j];
      j--;
    }
    System.out.println(element);
    for (int i = arr.length - 1; i >= 0; i--) {
      if (k - 1 == 0) {
        element = arr[i];
        break;
      }
      k--;
    }
    System.out.println(element);
  }
}