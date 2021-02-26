package com.mylearning.problems.v1.leetcode.medium;

import java.util.Stack;

public class DecodeString {
  
  public static void main(String[] args) {
    String s = "2[abc]3[cd]ef"; //accaccacc   3[a2[c]]    2[abc]3[cd]ef   abc3[cd]xyz
    System.out.println(s.indexOf('['));
    System.out.println(s.indexOf(']'));
    int i1 = '6' - '0';
    System.out.println();
    //System.out.println(decode(s, 0, s.length() - 1));
    Stack<Integer> intStack = new Stack<>();
    Stack<String> strStack = new Stack<>();
    int i = 0;
    String res = "";
    while(i < s.length()) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        int num = 0;
        while (Character.isDigit(s.charAt(i))) {
          num = num * 10 + s.charAt(i) - '0';
          i++;
        }
        intStack.push(num);
      } else if (c == '[') {
        strStack.push(res);
        res = "";
        i++;
      } else if (c == ']') {
        StringBuilder sb = new StringBuilder(strStack.pop());
        int count = intStack.pop();
        for (int j = 0; j < count; j++) {
          sb.append(res);
        }
        res = sb.toString();
        i++;
      } else {
        res += c;
        i++;
      }
    }
    System.out.println(res);
  }
}
