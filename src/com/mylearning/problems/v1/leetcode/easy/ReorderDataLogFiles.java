package com.mylearning.problems.v1.leetcode.easy;

import java.util.Arrays;

public class ReorderDataLogFiles {

  public static void main(String[] args) {
    String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
    System.out.println(Arrays.toString(logs));
    Arrays.sort(logs, (s1, s2) -> {
      int i = s1.indexOf(' ');
      int j = s2.indexOf(' ');

      if (Character.isLetter(s1.charAt(i + 1)) && !Character.isLetter(s2.charAt(j + 1))) {
        return -1;
      } else if (Character.isLetter(s2.charAt(i + 1)) && !Character.isLetter(s2.charAt(j + 1))) {
        return 1;
      } else if (Character.isLetter(s1.charAt(i + 1))) {
        int compare = s1.substring(i + 1).compareTo(s2.substring(j + 1));
        if (compare == 0) return s1.compareTo(s2);
        return compare;
      } else {
        return 0;
      }
    });
    System.out.println(Arrays.toString(logs));
  }
}
