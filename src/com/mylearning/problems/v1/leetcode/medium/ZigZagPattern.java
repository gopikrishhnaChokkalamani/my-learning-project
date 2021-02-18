package com.mylearning.problems.v1.leetcode.medium;

import java.util.Arrays;

public class ZigZagPattern {
  
  public static void main(String[] args) {
    String s = "PAYPALISHIRING";
    int n = 3;
    //List<Character>[] arr = new ArrayList[n];
    int j = 0;
    
//    for (int i = 0; i < arr.length; i++) {
//      arr[i] = new ArrayList<>();
//    }
    if (s.length() < n) {
    
    }
    String[] arr = new String[n];
    Arrays.fill(arr, "");
    boolean d = true;
    for (int i = 0; i < s.length(); i++) {
      //arr[j].add(s.charAt(i));
      arr[j] += s.charAt(i);
      if (j == n - 1) {
        d = false;
      } else if (j == 0) {
        d = true;
      }
      if (d) {
        j++;
      } else {
        j--;
      }
    }
    
    String s1 = "";
    for (String m : arr) {
      s1 += m;
    }
    System.out.println(s1);
    
//    for (List<Character> a : arr) {
//      for (Character c : a) {
//        System.out.print(c);
//      }
//      System.out.print(" ");
//    }
  }
  
  public static String convert(String s, int n) {
    if (n == 1) {
      return s;
    }
    String[] arr = new String[n];
    Arrays.fill(arr, "");
    boolean d = true;
    int j = 0;
    for (int i = 0; i < s.length(); i++) {
      //arr[j].add(s.charAt(i));
      arr[j] += s.charAt(i);
      if (j == n - 1) {
        d = false;
      } else if (j == 0) {
        d = true;
      }
      if (d) {
        j++;
      } else {
        j--;
      }
    }
    
    String s1 = "";
    for (String m : arr) {
      s1 += m;
    }
    System.out.println(s1);
    return s1;
  }
    
}
