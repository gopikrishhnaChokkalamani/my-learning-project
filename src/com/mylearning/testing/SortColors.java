package com.mylearning.testing;

import java.util.Arrays;

public class SortColors {

  public static void main(String[] args) {
    int[] nums = {2, 0, 2, 1, 1, 0};
    int i = 0, j = nums.length - 1;
    System.out.println(Arrays.toString(nums));
    int k = j;
    while (i <= j) {
      if (nums[j] == 0) {
        swap(nums, i, j);
        i++;
      } else if (nums[j] == 2) {
        swap(nums, k, j);
        j--; k--;
      } else {
        j--;
      }
    }
    System.out.println(Arrays.toString(nums));
  }

  private static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
