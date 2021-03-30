package com.mylearning.testing;

import java.util.*;

public class GroupAnagrams {

  public static void main(String[] args) {
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

    Map<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
      char[] chars = s.toCharArray();
      Arrays.sort(chars);
      String s1 = new String(chars);
      map.computeIfAbsent(s1, k -> new ArrayList<>()).add(s);
    }
    List<List<String>> list = new ArrayList<>(map.values());
    for (List<String> l : list) {
      for (String s : l) {
        System.out.print(s + " ");
      }
      System.out.println();
    }
  }
}
