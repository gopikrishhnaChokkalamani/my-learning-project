package com.mylearning.problems.v1.leetcode.easy;

import java.util.Arrays;

public class ReverseString {

  public static void main(String[] args) {
    String[] s = {"h","e","l","l","o"};
    System.out.println(Arrays.toString(s));
    int i = 0;
    int j = s.length - 1;
    while (i <= j) {
      String tmp = s[i];
      s[i] = s[j];
      s[j] = tmp;
      i++; j--;
    }
    System.out.println(Arrays.toString(s));
  }
}
