package com.mylearning.datastructures.v1.sorting;

import java.util.Arrays;

public class QuickSort {
  
  public static void main(String[] args) {
    int[] arr = {3, 5, 2, 3, 1, 2, 4, 6, 5};
    System.out.println("UN SORTED : " + Arrays.toString(arr));
    quickSort(arr, 0, arr.length - 1);
    System.out.println("SORTED : " + Arrays.toString(arr));
  }
  
  private static void quickSort(int[] arr, int i, int j) {
    if (i < j) {
      int partition = partition(arr, i , j);
      quickSort(arr, i, partition - 1);
      quickSort(arr, partition + 1, j);
    }
  }
  
  private static int partition(int[] arr, int start, int end) {
    int i = start - 1;
    int j = start;
    int pivot = arr[end];
    while (j <= end) {
      if (arr[j] <= pivot) {
        i++;
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
      }
      j++;
    }
    return i;
  }
}
