package com.mylearning.problems.v1.internet;

public class isPrime {

  public static void main(String[] args) {
    int n = 19;

    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        System.out.println(false);
        break;
      }
    }
    System.out.println(true);
  }
}
