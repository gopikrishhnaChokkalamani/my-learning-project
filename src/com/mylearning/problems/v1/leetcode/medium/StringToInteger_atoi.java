package com.mylearning.problems.v1.leetcode.medium;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToInteger_atoi {

  public static void main(String[] args) {
    //System.out.println(Integer.MAX_VALUE);
    //System.out.println(Integer.MIN_VALUE);

    String s = "0987 with words";

    System.out.println(checkAndConvert(s));
    System.out.println(anotherWay(s));
  }

  private static int anotherWay(String s) {
    if (s.length() == 0)    return 0;
    int sign = 1, res = 0;
    boolean hasSign = false, hasDigit = false;
    for(int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!Character.isDigit(c)) {
        if (hasDigit) {
          return res*sign;
        }
        if (c == ' ' && !hasSign) {
          continue;
        } else if ((c == '-' || c == '+') && !hasSign && res == 0) {
          sign = c == '-'? -1 : 1;
          hasSign = true;
          continue;
        }
        return res*sign;
      }
      hasDigit = true;
      int d = c - '0';
      if (res > Integer.MAX_VALUE/10 || res*10 > Integer.MAX_VALUE - d) {
        return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }
      res = res * 10 + d;
    }
    return res*sign;
  }

  private static int checkAndConvert(String s) {
    if (s == null || s.length() == 0) return 0;

    Pattern p = Pattern.compile("^\\s*([+-])?(\\d+).*$");
    Matcher m = p.matcher(s);
    if (m.matches()) {
      boolean isNegative = "-".equals(m.group(1));
      s = m.group(2);
      String max = String.valueOf(Integer.MAX_VALUE);
      String min = String.valueOf(Integer.MIN_VALUE).substring(1);

      if (isNegative) {
        if (s.length() > max.length() || s.length() == max.length() && s.compareTo(min) > 0) return Integer.MIN_VALUE;
        else return Integer.valueOf("-" + s);
      } else {
        if (s.length() > max.length() || s.length() == max.length() && s.compareTo(max) > 0) return Integer.MAX_VALUE;
        else return Integer.valueOf(s);
      }
    }
    return 0;
  }
}
