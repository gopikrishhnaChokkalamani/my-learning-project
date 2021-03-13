package com.mylearning.problems.v1.internet;

import java.util.Arrays;

public class ReverseArray {
  
  public static void main(String[] args) {
    int [] arr = {23, 5, 7, 9, 10, 1, 25, 11};
    
    int tmp = 0, n = arr.length;
    for (int i = 0; i < arr.length / 2; i++) {
      tmp = arr[i];
      arr[i] = arr[n - i - 1];
      arr[n - i - 1] = tmp;
    }
    System.out.println(Arrays.toString(arr));
    int [] a = {23, 5, 7, 9, 10, 1, 25, 11};
    easyReverse(a);
    System.out.println(Arrays.toString(a));
  }

  private static void easyReverse(int[] arr) {
    int i = 0, j = arr.length - 1;
    while (i < j) {
      int tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
      i++; j--;
    }
  }
}
