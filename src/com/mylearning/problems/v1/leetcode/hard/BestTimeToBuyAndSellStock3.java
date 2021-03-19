package com.mylearning.problems.v1.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class BestTimeToBuyAndSellStock3 {

  public static void main(String[] args) {
    int[] arr = {3, 3, 5, 0, 0, 3, 1, 4};
    int fb = Integer.MIN_VALUE, sb = Integer.MIN_VALUE, fs = 0, ss = 0;
    for (int i = 0; i < arr.length; i++) {
      fb = Math.max(fb, -arr[i]);
      fs = Math.max(fs, fb + arr[i]);
      sb = Math.max(sb, fs - arr[i]);
      ss = Math.max(ss, sb + arr[i]);
    }
    System.out.println(ss);
  }
}