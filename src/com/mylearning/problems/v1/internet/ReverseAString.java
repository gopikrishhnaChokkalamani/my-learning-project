package com.mylearning.problems.v1.internet;

public class ReverseAString {
  
  public static void main(String[] args) {
    String s = "MODULE";
    int i = s.length() - 1;
    while(i >= 0) {
      System.out.print(s.charAt(i));
      i--;
    }
  }
}
