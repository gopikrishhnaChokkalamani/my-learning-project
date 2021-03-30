package com.mylearning.testing;

import java.util.*;

public class WordLadder {

  public static void main(String[] args) {
    String[] words = {"hot","dot","dog","lot","log","cog"};
    List<String> list = new ArrayList<>();
    for (String s : words) list.add(s);
    System.out.println(wordLadder(list));
  }

  private static int wordLadder(List<String> list) {
    String begin = "hit";
    String end = "cog";
    Queue<String> queue = new ArrayDeque<>();
    queue.add(begin);
    int count = 0;
    while (!queue.isEmpty()) {
      String s = queue.remove();
      Iterator<String> iterator = list.listIterator();
      while(iterator.hasNext()) {
        String str = iterator.next();
        if (isAdjacent(s, str)) {
          if (str.equals(end)) {
            return count;
          }
          count++;
          iterator.remove();
          queue.add(str);
        }
      }
    }
    return 0;
  }

  private static boolean isAdjacent(String a, String b) {
    int count = 0;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) != b.charAt(i)) {
        count++;
      }
    }
    return count > 1 ? false : true;
  }
}
