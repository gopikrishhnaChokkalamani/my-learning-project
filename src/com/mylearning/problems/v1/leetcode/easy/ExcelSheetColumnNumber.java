package com.mylearning.problems.v1.leetcode.easy;

public class ExcelSheetColumnNumber {

  public static void main(String[] args) {
    String columnTile = "FXSHRXW";

    int base = 26;
    int num = 0;
    for (int i = 0; i < columnTile.length(); i++) {
      int index = columnTile.charAt(i) - 'A' + 1;
      num = num * base + index;
    }
    System.out.println(num);
  }
}
