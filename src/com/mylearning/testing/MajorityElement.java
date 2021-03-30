package com.mylearning.testing;

public class MajorityElement {

  public static void main(String[] args) {
    int[] arr = {3, 2, 3};
    int res = arr[0];
    int count = 1;
    for (int i = 1; i < arr.length - 1; i++) {
      if (count == 0) res = arr[i];
      count += res == arr[i] ? 1 : -1;
    }
  }
}
