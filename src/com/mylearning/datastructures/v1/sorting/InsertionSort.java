package com.mylearning.datastructures.v1.sorting;

import java.util.Arrays;

public class InsertionSort {
  
  //example - product of array itself
  public static void main(String[] args) {
    int[] arr = {3, 5, 2, 3, 1, 2, 4, 6, 5};
    int swap = 0;
    for (int i = 1; i < arr.length; i++) {
      int j = i;
      while (j >= 1) {
        if (arr[j] < arr[j - 1]) {
          swap++;
          int tmp = arr[j];
          arr[j] = arr[j - 1];
          arr[j - 1] = tmp;
        }
        j--;
      }
    }
    System.out.println(swap);
    System.out.println(Arrays.toString(arr));
  }
}