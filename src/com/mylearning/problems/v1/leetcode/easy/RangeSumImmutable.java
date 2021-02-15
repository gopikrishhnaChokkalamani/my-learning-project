package com.mylearning.problems.v1.leetcode.easy;

public class RangeSumImmutable {
  
  public static void main(String[] args) {
    int[] nums = {-2, 0, 3, -5, 2, -1};
    NumArray n = new NumArray(nums);
    System.out.println(n.sumRange(0, 2));
    System.out.println(n.sumRange(2, 5));
    System.out.println(n.sumRange(0, 5));
  }
  
  static class NumArray {
    
    int[] dp;
    
    public NumArray(int[] nums) {
      int n = nums.length;
      dp = new int[n + 1];
      dp[0] = 0;
//      int tmp = nums[0];
//      for (int i = 1; i < n; i++) {
//        dp[i] = tmp;
//        tmp += nums[i];
//      }
      for (int i = 1; i <= n; i++) {
        dp[i] = dp[i - 1] + nums[i - 1];
      }
    }
    
    public int sumRange(int i, int j) {
      return dp[j + 1] - dp[i];
    }
  }
}
