package com.mylearning.problems.v1.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInString3 {

  public static void main(String[] args) {
    String s = "Let's take LeetCode contest";

    String[] sarr = s.split(" ");

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < sarr.length; i++) {
      String tmp = sarr[i];
      int j = tmp.length();
      while (--j >= 0) {
        sb.append(tmp.charAt(j));
       // j--;
      }
      sb.append(" ");
    }
    System.out.println(sb.toString().trim());
    System.out.println(reverseWords(s));
  }

  public static String reverseWords(String s) {

    List<String> result = new ArrayList<>();
    String[] str = s.split(" ");

    for(int i = 0; i < str.length; i++) {
      StringBuilder sb = new StringBuilder();
      result.add(sb.append(str[i]).reverse().toString());
    }

    return String.join(" ", result);
  }
}
