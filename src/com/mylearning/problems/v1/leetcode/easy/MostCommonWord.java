package com.mylearning.problems.v1.leetcode.easy;

import java.util.*;
import java.util.stream.Collectors;

public class MostCommonWord {

  /*

  "a, a, a, a, b,b,b,c, c"
["a"]
   */

  public static void main(String[] args) {
    String para = "Bob hit a ball, the hit BALL flew far after it was hit.";
    String[] banned = {"hit"};

    String replaced = para.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();

    String[] s = replaced.split("\\s");

    //Arrays.sort(s);

    Set<String> set = new HashSet<>(Arrays.asList(banned));

    Map<String, Long> collect = Arrays.stream(para.replaceAll("[!?',;.]", "").toLowerCase().split(" "))
        .filter(s1 -> !set.contains(s1))
        .collect(Collectors.groupingBy(s1 -> s1, Collectors.counting()));
    //collect.remove(banned[0]);
    System.out.println(Collections.max(collect.entrySet(), Map.Entry.comparingByValue()).getKey());
  }

  public String mostCommonWord(String paragraph, String[] banned) {
    Map<String, Integer> wordAndCount = new HashMap<String, Integer>();
    Set<String> bansSet = new HashSet<>(Arrays.asList(banned));
    String[] words = paragraph.toLowerCase().split("\\W+");
    int max = 0;
    String res = "";
    for(String word:words){
      if(bansSet.contains(word)) continue;
      wordAndCount.put(word, wordAndCount.getOrDefault(word, 0) + 1);
      int count = wordAndCount.get(word);
      if( count > max) {
        max = count;
        res = word;
      }
    }

    return res;
  }

//  Set<String> banSet = new HashSet<>(Arrays.asList(banned));
//return Arrays.asList(paragraph.toLowerCase().split("\\W+")) // sanitize & tokenize
//      .stream()
//       .filter(word -> !banSet.contains(word))                                     // exclude banned words
//      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // build frequency map
//      .entrySet()
//       .stream()
//       .max(Map.Entry.comparingByValue()).get().getKey();
}
