package com.mylearning.problems.v1.dailycodingproblem.alibaba;

import java.util.ArrayList;
import java.util.List;

public class SumOfPrimeNumbersEqualToNumber {

  public static void main(String[] args) {
    int n = 12;
    List<Integer> list = find(n);
    for (Integer i : list) {
      System.out.print(i + " ");
    }
  }

  private static List<Integer> find(int n) {
    for (int i = 2; i <= n/2; i++) {
      if (isPrime(i) && isPrime(n - i)) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(n - i);
        return list;
      }
    }
    return null;
  }

  private static boolean isPrime(int n) {
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) return false;
    }
    return true;
  }
}
