package com.mylearning.problems.v1.leetcode.medium;

public class LongestPalindromicSubString {
  
  public static void main(String[] args) {
    bruteforce(); // O(n^3)
    System.out.println("###################### - just count");
    System.out.println(justCount());
    System.out.println(findLongestPalindrome());
  }

  private static int justCount() {
    String s = "ac";
    String str = "";
    int count = findCount(s, 0, s.length() - 1);
    System.out.println(str);
    return count;
  }

  private static int findCount(String s, int i, int j) {
    if (i > j) return 0;
    if (i == j) return 1;
    int case1 = 0;
    if (s.charAt(i) == s.charAt(j)) {
      int remaining = j - i - 1;
      if (remaining == findCount(s, i + 1, j - 1)) {
        System.out.println(i + " --- "+ j);
        String subStr = "";
        for (int k = i; k <= j; k++) {
          subStr += s.charAt(k);
        }
        System.out.println(subStr);
        case1 = remaining + 2;
      }
    }
    int case2 = findCount(s, i, j - 1);
    int case3 = findCount(s, i + 1, j);
    return Math.max(case1, Math.max(case2, case3));
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

  static int resultStart;
  static int noOfElements;

  private static String findLongestPalindrome() {
    String s = "babad";
    if (s == null || s.length() <= 1) return s;

    for (int i = 0; i < s.length(); i++) {
      expand(s, i, i);
      expand(s, i, i + 1);
    }
    return s.substring(resultStart, resultStart + noOfElements);
  }

  //you are assuming that i is the midpoint and expanding at left and right to see if the characters are same
  private static void expand(String s, int start, int end) {
    while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
      start--;
      end++;
    }
    if (noOfElements < end - start - 1) {
      resultStart = start + 1;
      noOfElements = end - start - 1;
    }
  }
}