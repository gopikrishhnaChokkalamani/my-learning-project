package com.mylearning.testing;

public class LongestCommonPrefix {

  public static void main(String[] args) {
    String[] str = {"dog","racecar","car"};   //"dog","racecar","car"   "flower", "flow", "flight"

    //logic used
    String s = "flower";
    String s1 = "fl";
    System.out.println(s.indexOf(s1));

    String prefix = str[0];
    for (int i = 1; i < str.length; i++) {
      while (str[i].indexOf(prefix) != 0) {
        prefix = prefix.substring(0, prefix.length() - 1);
      }
    }
    System.out.println(prefix);
  }
}
