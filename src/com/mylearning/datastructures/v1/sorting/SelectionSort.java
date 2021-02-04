package com.mylearning.datastructures.v1.sorting;

import java.util.Arrays;

public class SelectionSort {
  
  //example - min swap problems
  public static void main(String[] args) {
    int[] arr = {3, 5, 2, 3, 1, 2, 4, 6, 5};
    int swaps = 0;
    for (int i = 0; i < arr.length; i++) {
      int minIndex = i;
      for (int j = i; j < arr.length; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }
      if (minIndex != i) {
        swaps++;
        int tmp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = tmp;
      }
    }
    System.out.println(swaps);
    System.out.println(Arrays.toString(arr));
  }
}
