package com.mylearning.problems.v1.leetcode.easy;

public class LongestCommonPrefix {
  
  public static void main(String[] args) {
    String[] strs = {"flower", "flow", "flight"};
    int l = strs.length;
    if (strs.length == 1) {
      //return strs[0];
    }
    String prefix = "";
    for (int i = 0; i < strs.length - 1; i++) {
      prefix = findCommonPrefix((prefix == "") ? strs[i] : prefix, strs[i + 1], 0, 0);
      if (prefix == null || prefix == "") {
        System.out.println("No Common Prefix between " + strs[i] + " and " + strs[i+1]);
        //return "";
      }
      System.out.println("Common Prefix between " + strs[i] + " and " + strs[i+1]  + " is " + prefix);
    }
    //return prefix;
  }

  private static String findCommonPrefix(String s1, String s2, int i, int j) {
    if (i == s1.length() || j == s2.length()) {
      return "";
    }
    if (s1.charAt(i) != s2.charAt(j)) {
      return "";
    }
    return s1.charAt(i) + findCommonPrefix(s1, s2, i + 1, j + 1);
  }
}
