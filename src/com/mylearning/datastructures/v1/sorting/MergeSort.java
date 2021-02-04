package com.mylearning.datastructures.v1.sorting;

import java.util.Arrays;

public class MergeSort {
  
  public static void main(String[] args) {
    int[] arr = {3, 5, 2, 3, 1, 2, 4, 6, 5};
    System.out.println("UN SORTED : " + Arrays.toString(arr));
    mergeSort(arr, 0, arr.length - 1);
    System.out.println("SORTED : " + Arrays.toString(arr));
  }
  
  private static void mergeSort(int[] arr, int i, int j) {
    if (i < j) {
      int center = (i + j) / 2;
      mergeSort(arr, i, center);
      mergeSort(arr, center + 1, j);
      merge(arr, i, center, j);
    }
  }
  
  private static void merge(int[] arr, int start, int center, int end) {
    int lSize = center - start + 2;
    int rSize = end - center + 1;
    int[] left = new int[lSize];
    int[] right = new int[rSize];
    
    for (int i = 0; i <= center - start + 1; i++) {
      left[i] = arr[start + i];
    }
    
    for (int j = 0; j < end - center;j++) {
      right[j] = arr[center + j + 1];
    }
    
    left[center - start + 1] = Integer.MAX_VALUE;
    right[end - center] = Integer.MAX_VALUE;
    
    int i = 0, j = 0, k = start;
    while (k <= end) {
      if (left[i] < right[j]) {
        arr[k] = left[i];
        i++;
      } else {
        arr[k] = right[j];
        j++;
      }
      k++;
    }
  }
}
