package com.mylearning.problems.v1.leetcode.medium;

import java.util.Arrays;

public class LargestNumber {
  
  public static void main(String[] args) {
    int[] arr = {3, 30, 34, 5, 9};
    
    String[] sArr = new String[arr.length];
    
    for (int i = 0; i < arr.length; i++) {
      sArr[i] = Integer.toString(arr[i]);
    }
  
    Arrays.sort(sArr, (a, b) -> {
      String o1 = a + b;
      String o2 = b + a;
      return o2.compareTo(o1);
    });
    
    if (sArr[0].equals("0")) {
      //return "0";
      return;
    }
    
    StringBuilder sb = new StringBuilder();
    for (String s : sArr) {
      sb.append(s);
    }
  
    System.out.println(sb.toString());
    
  }
}
