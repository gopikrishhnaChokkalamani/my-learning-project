package com.mylearning.problems.v1.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {

//  Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//  An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//  Example 1:
//  Input: strs = ["eat","tea","tan","ate","nat","bat"]
//  Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//  Example 2:
//  Input: strs = [""]
//  Output: [[""]]
//  Example 3:
//  Input: strs = ["a"]
//  Output: [["a"]]
  
  public static void main(String[] args) {
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> res = new ArrayList<>();
    
    Map<String, ArrayList<String>> map = new HashMap<>();
    for (String s : strs) {
      int[] alphabets = new int[26];
      for (int i = 0; i < s.length(); i++) {
        alphabets[s.charAt(i) - 'a']++;
      }
      
      StringBuilder sb = new StringBuilder();
      for (Integer c : alphabets) {
        sb.append(c).append("#");
      }
      String string = sb.toString();
  
      map.computeIfAbsent(string, s1 -> new ArrayList<>()).add(s);
      
//      if (map.containsKey(string)) {
//        ArrayList<String> strings1 = map.get(string);
//        strings1.add(s);
//        map.put(string, strings1);
//      } else {
//        ArrayList<String> ana = new ArrayList<>();
//        ana.add(s);
//        map.put(string, ana);
//      }
    }
    
    for (List<String> l : map.values()) {
      res.add(l);
    }
    
    for (List<String> l : res) {
      System.out.println(l);
    }
    
    anotherSolution(strs);
  }
  
  public static void anotherSolution(String[] strs) {
    List<List<String>> res = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
      char[] chars = s.toCharArray();
      Arrays.sort(chars);
      String key = new String(chars);
      map.computeIfAbsent(key, s1 -> new ArrayList<>()).add(s);
    }
    //map.values().stream().collect(Collectors.toList())
    for (List<String> l : new ArrayList<>(map.values())) {
      System.out.println(l);
    }
  }
}
