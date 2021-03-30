package com.mylearning.testing;

import java.util.Arrays;

public class ZigZagConversion {

  /*
  Zig Zag Pattern

  P   A   H   N
  A P L S I I G
  Y   I   R

  you will return PAHNAPLSIIGYIR
  PAHN APLSIIG YIR
  */

  public static void main(String[] args) {
    String s = "PAYPALISHIRING";
    int rows = 3;
    System.out.println(convert(s, rows));
  }

  public static String convert(String s, int rows) {
    if (s == null || s.length() == 0) return s;
    if (s.length() <= rows) return s;

    String[] newStr = new String[rows];
    Arrays.fill(newStr, "");
    int j = 0;
    boolean down = false;
    for (int i = 0; i < s.length(); i++) {
      newStr[j] += s.charAt(i); //u r not assigning, but appending //but this will slow down the execution time
      if (j == rows - 1) down = false;
      else if (j == 0) down = true;
      if (down) j++;
      else j--;
    }
    System.out.println(Arrays.toString(newStr));

    String result ="";
    for (String r : newStr) {
      result += r;
    }
    return result;
  }
}
