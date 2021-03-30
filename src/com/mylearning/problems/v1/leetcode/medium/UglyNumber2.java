package com.mylearning.problems.v1.leetcode.medium;

public class UglyNumber2 {

  //prime factors are only 2, 3, and or 5
  public static void main(String[] args) {
    System.out.println(nthUglyNumber(10));
    System.out.println(uglyNumber(10));
  }

  public static int nthUglyNumber(int n) {
    int[] ugly = new int[n];
    ugly[0] = 1;
    int index2 = 0, index3 = 0, index5 = 0;
    int factor2 = 2, factor3 = 3, factor5 = 5;
    for(int i=1;i<n;i++){
      int min = Math.min(Math.min(factor2,factor3),factor5);
      ugly[i] = min;
      if(factor2 == min)
        factor2 = 2*ugly[++index2];
      if(factor3 == min)
        factor3 = 3*ugly[++index3];
      if(factor5 == min)
        factor5 = 5*ugly[++index5];
    }
    return ugly[n-1];
  }

  public static int uglyNumber(int n ) {
    int count = 1, i = 2;
    while (count <= n) {
      if (isUgly(i)) {
        count++;
      }
      i++;
    }
    return i - 1;
  }

  private static boolean isUgly(int i) {
    if (i % 2 == 0) return true;
    if (i % 3 == 0) return true;
    if (i % 5 == 0) return true;
    return false;
  }
}