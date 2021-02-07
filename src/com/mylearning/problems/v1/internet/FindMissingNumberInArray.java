package com.mylearning.problems.v1.internet;

public class FindMissingNumberInArray {

//  Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
//  Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
//  Input: nums = [9,6,4,2,3,5,7,0,1]
//  Output: 8
//  Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
//
  public static void main(String[] args) {
    int[] arr = {9,6,4,2,3,5,7,0,1};
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    int n = arr.length;
    int actual_sum = (n * (n + 1) ) / 2;
    System.out.println(actual_sum - sum);
  }
}
