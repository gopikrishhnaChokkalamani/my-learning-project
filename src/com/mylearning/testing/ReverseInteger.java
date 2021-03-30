package com.mylearning.testing;

public class ReverseInteger {

  /*
  2,147,483,647

  7,463,847,412

  214,748,365
  463,847,412

   */

  public static void main(String[] args) {
    int x = 23423434;
    int rev = 0;
    System.out.println(Integer.MIN_VALUE);
    System.out.println(Integer.MAX_VALUE);
    System.out.println(Integer.MIN_VALUE/10);
    System.out.println(Integer.MAX_VALUE/10);
    System.out.println(x);
    while (x != 0) {
      if (x < Integer.MIN_VALUE / 10 || x > Integer.MAX_VALUE / 10) {
        break; //return false here
      }
      rev = rev * 10 + x % 10;
      x = x / 10;
    }
    System.out.println(rev);
  }
}
