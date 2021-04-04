package com.mylearning.problems.v1.leetcode.hard;

import java.util.concurrent.TimeUnit;

public class IntegerToString {

  public static void main(String[] args) {
    System.out.println(123 / 1000000000);  //prints quotient
    System.out.println(123 % 1000000000);  //prints reminder

    System.out.println(123 / 100);
    System.out.println(123 % 100);

    System.out.println(12 / 10);
    System.out.println(12 % 10);

    System.out.println(Integer.MAX_VALUE);

    long start = System.currentTimeMillis();
    builder(Integer.MAX_VALUE);
    System.out.println(sb.toString().trim());
    System.out.println("Time Taken " + (System.currentTimeMillis() - start));

    IntegerToString s = new IntegerToString();
    start = System.currentTimeMillis();
    System.out.println(s.numberToWords(Integer.MAX_VALUE));
    System.out.println("Time Taken " + (System.currentTimeMillis() - start));
  }

  static StringBuilder sb = new StringBuilder();
  static String[] uniques = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
      "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
  static String[] tens = {"Zero", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

  private static void builder(int num) {
    if (num >= 1000000000) {
      builder(num / 1000000000);
      sb.append("Billion").append(" ");
      builder(num % 1000000000);
    } else if (num >= 1000000) {
      builder(num / 1000000);
      sb.append("Million").append(" ");
      builder(num % 1000000);
    } else if (num >= 1000) {
      builder(num / 1000);
      sb.append("Thousand").append(" ");
      builder(num % 1000);
    } else if (num >= 100) { //123
      // num / 100 -> 1
      builder(num / 100);
      sb.append("Hundred").append(" ");
      builder(num % 100);
      //num % 100 -> 23
    } else if (num >= 20) { //21
      // num / 10 -> 2
      sb.append(tens[num/10]).append(" ");
      builder(num % 10);
      // num % 10 -> 1
    } else if (num > 0 && num < 20) {
      sb.append(uniques[num]).append(" ");
    }
  }

  private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
  private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
  private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

  public String numberToWords(int num) {
    if (num == 0) return "Zero";

    int i = 0;
    String words = "";

    while (num > 0) {
      if (num % 1000 != 0)
        words = helper(num % 1000) +THOUSANDS[i] + " " + words;
      num /= 1000;
      i++;
    }

    return words.trim();
  }

  private String helper(int num) {
    if (num == 0)
      return "";
    else if (num < 20)
      return LESS_THAN_20[num] + " ";
    else if (num < 100)
      return TENS[num / 10] + " " + helper(num % 10);
    else
      return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
  }
}
