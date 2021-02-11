package com.mylearning.problems.v1.leetcode.medium;

import java.util.Arrays;

public class RotateArrayRight {

//  Given an array, rotate the array to the right by k steps, where k is non-negative.
//  Follow up:
//  Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
//  Could you do it in-place with O(1) extra space?
  
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7};
    System.out.println(Arrays.toString(arr));
    int k = 3;
    int l = arr.length - 1;
    while (k > 0) {
      int last = arr[l];
      for (int i = arr.length - 2; i >= 0 ; i--) {
        arr[i + 1] = arr[i];
      }
      arr[0] = last;
      k--;
    }
    System.out.println(Arrays.toString(arr));
  }
}
