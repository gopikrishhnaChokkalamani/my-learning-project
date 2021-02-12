package com.mylearning.problems.v1.leetcode.medium;

public class HouseRobber {
  
  public static void main(String[] args) {
    int[] nums = {2, 7, 9, 3, 1};
    if (nums.length == 0) {
      //return 0;
    }
    if (nums.length == 1) {
      // return nums[0];
    }
    System.out.println(rob(nums, 0, new Integer[nums.length]));
    Integer[] dp = new Integer[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {
      dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
    }
    System.out.println(dp[nums.length - 1]);
  }
  
  private static int rob(int[] nums, int i, Integer[] dp) {
    if (i > nums.length - 1) {
      return 0;
    }
    if (dp[i] == null) {
      int first = nums[i] + rob(nums, i + 2, dp);
      int second = rob(nums, i + 1, dp);
      dp[i] = Math.max(first, second);
    }
    return dp[i];
  }
}
