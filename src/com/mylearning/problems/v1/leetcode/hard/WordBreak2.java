package com.mylearning.problems.v1.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak2 {

  public static void main(String[] args) {
    String s = "catsanddog";
    List<String> words = Arrays.asList("cat","cats","and","sand","dog");

    wordBreak(s, words, 0);
    System.out.println();
  }
  static List<String> result = new ArrayList<>();
  public static boolean wordBreak(String s, List<String> words, int start) {

    return false;
  }
}
