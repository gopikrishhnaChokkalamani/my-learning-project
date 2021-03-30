package com.mylearning.testing;

public class PalindromeNumber {

  public static void main(String[] args) {
    int x = -121;
    System.out.println(isPalindrome(x));
  }

  public static boolean isPalindrome(int x) {
    if (x == 0) return true;
    if (x < 0) return false;
    int curr = x;
    int rev = 0;
    while (curr != 0) {
      rev = rev * 10 + curr % 10;
      curr = curr /10;
    }
    return x == rev;
  }
}
