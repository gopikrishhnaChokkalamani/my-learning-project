package com.mylearning.problems.v1.leetcode.medium;

import java.util.Arrays;

public class ProductofArrayExceptSelf {
  
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4};
    int[] p = new int[arr.length];
    
    int i = 0; // this is O(n^2) - last 2 test cases failing in leetcode
    while (i < arr.length) {
      int j = i + 1;
      int product = 1;
      int k = 0;
      while (k <= i - 1) {
        product *= arr[k];
        k++;
      }
      while (j < arr.length) {
        product *= arr[j];
        j++;
      }
      p[i] = product;
      i++;
    }
    System.out.println(Arrays.toString(p));
    //O(n)
    anotherMethod(arr);
    anotherMethod1(arr);
  }
  
  //{1, 2, 3, 4};
  private static void anotherMethod1(int[] arr) {
    int[] p = new int[arr.length];
    Arrays.fill(p, 1);
    int tmp = 1;
    for (int i = 0; i < arr.length; i++) {
      p[i] = tmp;
      tmp *= arr[i];
    }
    System.out.println("---" + Arrays.toString(p));
    tmp = 1;
    // 1 1 2 6
    for (int i = arr.length - 1; i >= 0; i--) {
      p[i] *= tmp;
      tmp *= arr[i];
    }
    System.out.println(Arrays.toString(p));
  }
  
  //revisit this code
  private static void anotherMethod(int[] arr) {
    int[] prod = new int[arr.length];
    prod[0] = 1;
    for (int i = 1; i < arr.length; i++) {
      prod[i] = prod[i - 1] * arr[i - 1];
    }
    int tmp = 1;
    for (int i = arr.length - 2; i >= 0; i--) {
      prod[i] *= arr[i + 1] * tmp;
      tmp *= arr[i + 1];
    }
    System.out.println("hi " + Arrays.toString(prod));
  }
}