package com.mylearning.testing;

public class BestTimeToBuyAndSellStock {

  public static void main(String[] args) {
    int[] prices = {7, 1, 5, 3, 6, 4};
    int profit = 0;
    int buy = Integer.MAX_VALUE, buyIndex = 0, sellIndex = 0;
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < buy) {
        buy = prices[i];
        buyIndex = i;
      } else {
        if (profit < prices[i] - buy) {
          profit = prices[i] - buy;
          sellIndex = i;
        }
      }
    }
    System.out.println("Buy for " + buy + " on day " + (buyIndex + 1));
    System.out.println("Sell on day " + (sellIndex + 1) + " for profit of " + profit);
  }
}
