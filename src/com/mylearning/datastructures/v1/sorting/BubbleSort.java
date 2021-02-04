package com.mylearning.datastructures.v1.sorting;

import java.util.Arrays;

public class BubbleSort {
  
  public static void main(String[] args) {
    int[] arr = {3, 5, 2, 3, 1, 2, 4, 6, 5};
    int swap = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] > arr[j]) {
          swap++;
          int tmp = arr[j];
          arr[j] = arr[i];
          arr[i] = tmp;
        }
      }
    }
    System.out.println(swap);
    System.out.println(Arrays.toString(arr));
  }
}
