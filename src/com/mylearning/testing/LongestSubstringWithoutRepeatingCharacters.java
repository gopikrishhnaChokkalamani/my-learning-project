package com.mylearning.testing;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

  public static void main(String[] args) {
    String str = "abcabcbb";  //bbbbb
    int i = 0, j = 0, max = 0;
    Set<Character> set = new HashSet<>();
    while (i < str.length() && j < str.length()) {
      if (!set.contains(str.charAt(j))) {
        set.add(str.charAt(j));
        j++;
        max = Math.max(max, j - i);
      } else {
        set.remove(str.charAt(i));
        i++;
      }
    }
    System.out.println(max);
  }
}
