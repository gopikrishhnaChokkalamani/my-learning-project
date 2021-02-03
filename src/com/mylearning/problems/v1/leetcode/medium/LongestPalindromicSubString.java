package com.mylearning.problems.v1.leetcode.medium;

public class LongestPalindromicSubString {
  
  public static void main(String[] args) {
    bruteforce(); // O(n^3)
  }
  
  private static void bruteforce() {
    String s = "babad";
    //two possibilities for regular palindrome
    //aabbaa -> even
    //aabebaa -> odd
    int start = 0, end = 1;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        System.out.println(s.charAt(i) + " - " + s.charAt(j));
        int eq = 1;
        for (int k = 0; k < j - i + 1; k++) {
          System.out.println("--- " + s.charAt(i+k) + " - " + s.charAt(j - k));
          if (s.charAt(i+k) !=  s.charAt(j-k) ) {
            eq = 0;
          }
        }
        if (eq != 0 && (j - i + 1) > end) {
          start = i;
          end = j - i + 1;
        }
        System.out.println("End of k");
      }
      System.out.println("End of j");
    }
    int max = start + end - 1;
    StringBuilder str = new StringBuilder();
    for (int i = start; i <= max; i++) {
      str.append(s.charAt(i));
    }
    System.out.println(str.toString());
  }
}