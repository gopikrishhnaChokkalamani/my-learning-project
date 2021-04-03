package com.mylearning.problems.v1.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class WordBreak {

//  "cars"
//   ["car","ca","rs"]
//

  //replace or replaceAll will not work here
//  "aaaaaaa"
//      ["aaaa","aaa"]

//  "catsandog"
//      ["cats","dog","sand","and","cat"]

//  "leetcode"
//      ["leet","code"]

  //replcaeFirst will not work here
//  "applepenapple"
//      ["apple","pen"]

  public static void main(String[] args) {
    String s = "leetcode";
    List<String> arr = Arrays.asList("leet","code");
    System.out.println(s.substring(0, 0)); //nothing
    System.out.println(s.substring(0, 1));  // if leetcode string, first char of string, that all chars from 0, and before 1 in this case just l
    System.out.println(s.substring(0, 8));  //if leetcode -> then prints leetcode
    //System.out.println(s.substring(0, 9));  // will result in exception
    System.out.println(recursive(s, arr, 0));
    System.out.println(dp_memoization(s, arr, 0, new Boolean[s.length()]));
    System.out.println(dp_tabulation(s, arr));
    //System.out.println(obselete(s, Arrays.asList("aaaa","aaa")));
  }

  private static boolean dp_tabulation(String s, List<String> words) {
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 1; i <= s.length();i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && words.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[s.length()];
  }

  private static boolean dp_memoization(String s, List<String> words, int start, Boolean[] dp) {
    if (start == s.length()) return true;
    if (dp[start] != null) return dp[start];
    for (int end = start + 1; end <= s.length(); end++) {
      if (words.contains(s.substring(start, end)) && dp_memoization(s, words, end, dp)) return dp[start] = true;
    }
    return dp[start] = false;
  }

  private static boolean recursive(String s, List<String> words, int start) {
    if (start == s.length()) return true;
    for (int end = start + 1; end <= s.length(); end++) {
      if (words.contains(s.substring(start, end)) && recursive(s, words, end)) return true;
    }
    return false;
  }

  //see comments why this will not work
  public static boolean obselete(String name, List<String> wordDict) {

    Comparator<String> comparator = new Comparator<String>() {
      public int compare(String s1, String s2) {
        if (s1.length() == s2.length()) return 0;
        if (s1.length() > s2.length()) return 1;
        else return -1;
      }
    };

    Collections.sort(wordDict, comparator);
    for (String s : wordDict) {
      if (name.contains(s)) {
        //name = name.replaceAll(s, "");
        name = name.replaceFirst(s, "");
      }
    }
    return name.length() == 0 ? true : false;
  }
}
