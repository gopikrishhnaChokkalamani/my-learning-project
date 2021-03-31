package com.mylearning.problems.v1.leetcode.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class VerifyingAnAlienDictionary {

//  Example 1:
//  Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
//  Output: true
//  Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
//  Example 2:
//  Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
//  Output: false
//  Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
//["apple","app"]
//    "abcdefghijklmnopqrstuvwxyz"
//  ["hello","leetcode"]
//      "hlabcdefgijkmnopqrstuvwxyz"
  public static void main(String[] args) {
    System.out.println(isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    System.out.println(isAlienSortedAnother(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
  }

  private static boolean isAlienSortedAnother(String[] words, String order) {
    if (words == null || words.length == 0 || order == null || order.length() == 0) return false;

    Comparator<String> comparator = (s1, s2) -> {
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
          char a = s1.charAt(i);
          char b = s2.charAt(i);
          if (a != b) {
            if (order.indexOf(a) < order.indexOf(b)) return -1;
            else return 1;
          }
        }
        if (s1.length() == s2.length()) return 0;
        else if (s1.length() > s2.length()) return 1;
        else return -1;
      };

    PriorityQueue<String> queue = new PriorityQueue<>(comparator);
    for (String s : words) {
      queue.add(s);
    }

    int i = 0;
    while (!queue.isEmpty()) {
      if (!queue.remove().equals(words[i++])) return false;
    }

    return true;
  }

  public static boolean isAlienSorted(String[] words, String order) {
    if (words == null || words.length == 0 || order == null || order.length() == 0) return false;
    for (int i = 1; i < words.length; i++) {
      char[] word1 = words[i - 1].toCharArray(), word2 = words[i].toCharArray();
      int w1 = 0, w2 = 0;
      while (w1 < word1.length || w2 < word2.length) {
        try {
          if (order.indexOf(word1[w1]) > order.indexOf(word2[w2])) return false;
          else if (order.indexOf(word1[w1]) < order.indexOf(word2[w2])) break;
          else if (order.indexOf(word1[w1]) == order.indexOf(word2[w2])) {
            w1++;
            w2++;
          }
        } catch (ArrayIndexOutOfBoundsException e) {
          if (w1 == word1.length) break;
          else return false;
        }
      }
      //if (word1.length - 1 > w1) return false;
      int ii = 0;
    }
    return true;
  }
}
