package com.mylearning.problems.v1.hackerrank;

public class SherlockAndArray {

  public static void main(String[] args) {
    int[] arr = {5, 6, 8, 11};

    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }

    int right = sum - arr[0];
    int left = 0;

    for (int i = 0; i < arr.length - 1; i++) {
      if (left == right)
        break;
      left += arr[i];
      right -= arr[i + 1];
    }
    System.out.println();
  }
}
