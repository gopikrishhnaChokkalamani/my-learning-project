package com.mylearning.problems.v1.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

//  Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//  Example 1:
//  Input: n = 3
//  Output: ["((()))","(()())","(())()","()(())","()()()"]
//  Example 2:
//  Input: n = 1
//  Output: ["()"]
  
  //braces should follow open close order
  //number of open braces = 3 and number of closed braces = 3, i.e 3 pairs
  public static void main(String[] args) {
    int n = 2;
    List<String> list = new ArrayList<>();
    generateParanthesis(list, "",0, 0, n);
    for (String s : list) {
      System.out.println(s);
    }
  }
  
  private static void generateParanthesis(List<String> list, String s, int open, int close, int n) {
    if (s.length() == n * 2) {
      list.add(s);
      return;
    }
    if (open < n) {
      generateParanthesis(list, s+"(", open + 1, close, n);
    }
    if (close < open) {
      generateParanthesis(list, s+")", open, close + 1, n);
    }
  }
}
