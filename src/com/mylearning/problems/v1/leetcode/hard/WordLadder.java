package com.mylearning.problems.v1.leetcode.hard;

import java.util.*;

public class WordLadder {

  public static void main(String[] args) {
    String s1 = "hot";
    String s2 = "dog";
    String[] strs = {"hot","dog", "dot"};
    List<String> l = new ArrayList<>();
    for (String s : strs) {
      l.add(s);
    }
    System.out.println(wordLadder(s1, s2, l));
  }
  
  public static class Obj {
    String word;
    int len;
    Obj (String word, int len) {
      this.word = word;
      this.len = len;
    }
  }
  
  private static int wordLadder(String s1, String s2, List<String> list) {
    if (s1.length() == 0 || s2.length() == 0 || list == null) {
      return 0;
    }
    Queue<Obj> queue = new ArrayDeque<>();
    queue.add(new Obj(s1, 1));
    int j = 1;
    while (!queue.isEmpty()) {
      Obj curr = queue.remove();
      ListIterator<String> iterator = list.listIterator();
      while (iterator.hasNext()) {
        String fromList = iterator.next();
        if (isAdjacent(curr.word, fromList)) {
          if (fromList.equals(s2)) {
            System.out.println("End j -> " + j);
            return curr.len + 1;
          }
          System.out.println("j -> " + j);
          System.out.println("curr.len + 1 -> " + (curr.len));
          iterator.remove();
          queue.add(new Obj(fromList, curr.len + 1));
          j++;
        }
      }
    }
    return 0;
  }
  
  private static boolean isAdjacent(String s1, String s2) {
    int count = 0;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        count++;
        if (count > 1) {
          break;
        }
      }
    }
    return count > 1 ? false : true;
  }
}
