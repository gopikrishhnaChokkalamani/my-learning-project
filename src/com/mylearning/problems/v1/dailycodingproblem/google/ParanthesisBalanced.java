package com.mylearning.problems.v1.dailycodingproblem.google;

import java.util.Stack;

public class ParanthesisBalanced {

  public static void main(String[] args) {
    String s = "(()*";

    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '*') {
        stack.push(c);
      }
      else {
        if (stack.isEmpty()) {
          System.out.println(false);
          break;
        }
        char fromstack = stack.pop();
        if (fromstack == '(' && c == ')' || fromstack =='*' && c == ')' || fromstack == '*' && c == '*' || fromstack == '(' && c == '*') {
          continue;
        }
        System.out.println(false);
        break;
      }
    }

    if (!stack.isEmpty()) System.out.println(false);
    else System.out.println(true);
  }
}
