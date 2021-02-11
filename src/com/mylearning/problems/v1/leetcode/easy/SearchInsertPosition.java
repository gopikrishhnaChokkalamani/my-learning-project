package com.mylearning.problems.v1.leetcode.easy;

public class SearchInsertPosition {
  
  public static void main(String[] args) {
    int[] a = {1,3,5,6};
    int t = 2;
    
    for (int i = 0; i < a.length; i++) {
      if (a[i] == t) {
        System.out.println(i);
        return;
      }
      if (a[i] > t) {
        System.out.println(i);
        return;
      }
    }
    System.out.println(a.length);
  }
}
