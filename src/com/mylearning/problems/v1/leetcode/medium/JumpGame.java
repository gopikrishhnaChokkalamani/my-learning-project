package com.mylearning.problems.v1.leetcode.medium;

public class JumpGame {

  public static void main(String[] args) {
    int[] nums = {2,3,1,1,4};

    int goodIndex = nums.length - 1;

    for (int i = nums.length - 2; i >= 0; i--) {
      if (i + nums[i] >= goodIndex) {
        System.out.println(i);
        goodIndex = i;
      }
    }

    System.out.println(goodIndex == 0);
  }
}


//  int max = 0;
//        for(int i = 0; i <= max; i++){
//            max = Math.max(max, i + nums[i]);
//            if(max >= nums.length - 1){
//            return true;
//            }
//            }
//            return max >= nums.length - 1;