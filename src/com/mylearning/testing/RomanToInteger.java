package com.mylearning.testing;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    map.put("I", 1);
    map.put("IV", 4);
    map.put("V", 5);
    map.put("IX", 9);
    map.put("X", 10);
    map.put("XL", 40);
    map.put("L", 50);
    map.put("XC", 90);
    map.put("C", 100);
    map.put("CD", 400);
    map.put("D", 500);
    map.put("CM", 900);
    map.put("M", 1000);

    String s = "IX";  //LVIII  MCMXCIV
    int i = 0, j = 1; //can do with two pointers also and increment
    int result = 0;
    while (i < s.length()) {
      if (i != s.length() - 1 && map.containsKey(String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i+1)))) {
        result += map.get(String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i+1)));
        i = i + 2;
      } else {
        result += map.get(String.valueOf(s.charAt(i)));
        i++;
        j--;
      }
    }
    System.out.println(result);
  }
}
