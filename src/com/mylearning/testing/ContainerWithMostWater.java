package com.mylearning.testing;

public class ContainerWithMostWater {

  public static void main(String[] args) {
    int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    System.out.println(maxArea(heights));
  }

  private static int maxArea(int[] heights) {
    if (heights == null || heights.length == 0) return 0;
    int i = 0, j = heights.length - 1, max = 0;
    while (i < j) {
      int breadth = Math.min(heights[i], heights[j]);
      int length = j - i;
      max = Math.max(max, breadth * length);
      if (heights[i] < heights[j]) {
        i++;
      } else {
        j--;
      }
    }
    return max;
  }
}
