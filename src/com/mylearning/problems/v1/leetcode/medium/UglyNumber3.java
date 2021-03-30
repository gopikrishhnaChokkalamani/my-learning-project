package com.mylearning.problems.v1.leetcode.medium;

public class UglyNumber3 {

  public static void main(String[] args) {
    System.out.println(nthUglyNumber(3, 2, 3, 5));
  }

  public static int nthUglyNumber(int n, int a, int b, int c) {
    int num = 0;
    long c1 = a,c2 = b,c3 = c;
    for (int i = 1; i <= n; i++) {
      num = Math.min(a, Math.min(b, c));
      if (num == c1) c1 *= a;
      if (num == c2) c3 *= b;
      if (num == c3) c3 *= c;
    }
    return num;
  }
}
