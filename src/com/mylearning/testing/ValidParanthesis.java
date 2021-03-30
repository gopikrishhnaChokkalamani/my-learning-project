package com.mylearning.testing;

import java.util.*;

public class ValidParanthesis {

  public static void main(String[] args) {
    String s = "{[]}"; //([)]  {[]}  ()[]{}
    System.out.println(isValid(s));
  }

  public static boolean isValid(String s) {
    if (s == null || s.length() == 1) return false;

    Deque<Character> dequeue = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '{' || c == '(' || c == '[') dequeue.push(c);
      else {
        if (dequeue.isEmpty()) return false;
        char fromStack = dequeue.pop();
        if (fromStack == '{' && c == '}' || fromStack == '[' && c == ']' || fromStack == '(' && c == ')') continue;
        else return false;
      }
    }
    return dequeue.isEmpty() ? true : false;
  }

  public boolean isValidAnother(String s) {
    Map<Character,Character> map = new HashMap<>();
    map.put('}','{');
    map.put(')','(');
    map.put(']','[');
    char ca[] = s.toCharArray();
    Stack<Character> stack = new Stack<Character>();
    for(char c:ca){
      if(map.containsKey(c)){
        if(stack.isEmpty()){
          return false;
        }
        Character pop = stack.pop();
        if(pop==null||!pop.equals(map.get(c))){
          return false;
        }
      }else{
        stack.push(c);
      }
    }
    return stack.isEmpty();
  }
}
