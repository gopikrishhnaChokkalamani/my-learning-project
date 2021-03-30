package com.mylearning.testing;

import java.util.Arrays;

public class ProductOfArrayExceptItself {

  public static void main(String[] args) {
    productOfArrayQuadratic();
    productOfArrayLinear();
  }

  private static void productOfArrayQuadratic() {
    int[] arr = {1, 2, 3, 4};
    System.out.println(Arrays.toString(arr));
    int[] result = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      int j = 0, prod = 1;
      while (j < arr.length) {
        if (arr[i] == arr[j]) {
          j++;
          continue;
        }
        prod *= arr[j];
        j++;
      }
      result[i] = prod;
    }
    System.out.println(Arrays.toString(result));
  }

  private static void productOfArrayLinear() {
    int[] arr = {1, 2, 3, 4};
    System.out.println(Arrays.toString(arr));

    int[] res = new int[arr.length];
    Arrays.fill(res, 1);
    int tmp = 1;
    for (int i = 0; i < arr.length; i++) {
      res[i] = tmp;
      tmp *= arr[i];
    }
    tmp = 1;
    for (int i = arr.length - 1; i >= 0; i--) {
      res[i] *=tmp;
      tmp *=arr[i];
    }
    System.out.println(Arrays.toString(res));
  }
}