package com.mylearning.problems.v1.leetcode.medium;

public class ReverseWordsinAString {

  public static void main(String[] args) {
    String s = "a good   example";
    String[] sarr = s.split("\\W+");
    System.out.println(s);

    String newstring = "";
    StringBuilder sb = new StringBuilder();
    for (int i = sarr.length - 1; i >= 0; i--) {
      sb.append(sarr[i]).append(" ");
    }
    newstring = sb.toString().trim();
    System.out.println(newstring);
  }
}
