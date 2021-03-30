package com.mylearning.datastructures.v1.greedy;

public class CoinChangeProblem {
  
  public static void main(String[] args) {
    int[] denominations = {1,2,5};
    int input = 11;
    int index = denominations.length - 1;
    int count = 0;
    while (true) {
      int  denomination = findRightDenomination(denominations, input, index);
      if (input >= denomination) {
        count++;
        System.out.println(denomination);
        input = input - denomination;
      }
      if (input == 0) break;
    }
    System.out.println(count);
  }
  
  private static int findRightDenomination(int[] denominations, int input, int index) {
    if (index < 0) {
      return 0;
    }
    if (input >= denominations[index]) {
      return denominations[index];
    }
    return findRightDenomination(denominations, input, --index);
  }
}