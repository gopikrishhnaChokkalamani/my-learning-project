package com.mylearning.problems.v1.internet;

public class ReverseAnArray {
  
  public static void main(String[] args) {
    int [] arr = {23, 5, 7, 9, 10, 1, 25, 11};
    int atIndex = 2;
    for (int i = 0; i < arr.length; i++) {
      int n = i % atIndex;
    }
  }
}
