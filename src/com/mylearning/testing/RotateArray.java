package com.mylearning.testing;

import java.util.Arrays;

public class RotateArray {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7};
    int k = 3;
    System.out.println(Arrays.toString(arr));
    while (k-- > 0) {
      int tmp = arr[arr.length - 1];
      for (int i = arr.length - 2; i >= 0; i--) {
        arr[i + 1] = arr[i];
      }
      arr[0] = tmp;
    }
    System.out.println(Arrays.toString(arr));

    int[] a = {1, 2, 3, 4, 5, 6, 7};
    rotate(a, 3);
    System.out.println(Arrays.toString(a));
  }

  public static void rotate(int[] nums, int k) {
    k = k % nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }

  public static void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }
}
