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
  }
}
