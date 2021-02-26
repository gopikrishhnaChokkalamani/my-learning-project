package com.mylearning.problems.v1.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
  
  public static void main(String[] args) {
    int[] nums = {3, 2, 3};
    System.out.println(majorityElement(nums));
  }
  
  private static int majorityElement(int[] arr) {
    int count = 1;
    //int count = 0;
//    int res = 0;
//    for (int num : arr) {
//      if (count == 0) {
//        res = num;
//      }
//      count += res == num ? 1 : -1;
//    }
    int res = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (count == 0) res = arr[i];
      count += res == arr[i] ? 1 : -1;
    }
  
    //there s a hashmap solution, that will solve the problem by not going to through the entire array
    //using n/2 concept
    
    return res;
  }
}
