package com.mylearning.problems.v1.leetcode.medium;

import java.util.Arrays;

public class SortColors {
  
  public static void main(String[] args) {
    int[] nums = {2,0,2,1,1,0};  // 1, 0, 2
    System.out.println(Arrays.toString(nums));
    //sortColors(nums);
    sortColors1(nums);
    System.out.println(Arrays.toString(nums));
  }
  
  private static void sortColors1(int[] nums) {
    int i = 0, j = nums.length - 1;
    int k = j;
    while (i <= j) {
      if (nums[j] == 0) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        i++;
      } else if (nums[j] == 2) {
        int tmp = nums[k];
        nums[k] = nums[j];
        nums[j] = tmp;
        j--; k--;
      } else {
        j--;
      }
    }
    int ii = 0;
  }
  
  
  //insertion
  public static void sortColors(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      int j = i;
      while (j >= 1) {
        if (nums[j] < nums[j - 1]) {
          int tmp = nums[j - 1];
          nums[j - 1] = nums[j];
          nums[j] = tmp;
        }
        j--;
      }
    }
  }
}
