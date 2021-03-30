package com.mylearning.testing;

import java.util.Arrays;

public class LargestNumber {

  public static void main(String[] args) {
    String s = "102";
    String p = "210";
    System.out.println(s.compareTo(p));
    System.out.println(p.compareTo(s));

    int[] arr = {10, 2};

    String[] sarr = new String[arr.length];
    for (int i = 0; i < arr.length; i++) {
      sarr[i] = Integer.toString(arr[i]);
    }

    Arrays.sort(sarr, (a, b) -> {
      String o1 = a + b;
      String o2 = b + a;
      return o2.compareTo(o1);
    });

    StringBuilder sb = new StringBuilder();
    for (String sa : sarr) {
      sb.append(sa);
    }
    System.out.println(sb.toString());
  }
}
