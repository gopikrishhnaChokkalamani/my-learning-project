package com.mylearning.problems.v1.leetcode.hard;

import java.util.Stack;

public class TrappingRainWater {

  public static void main(String[] args) {
    int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

    System.out.println(trap(heights));
  }

  public static int trap(int[] heights) {
    int i = 0, j = heights.length - 1;
    int currHeight = 0;
    int water = 0;
    while (i < j) {
      while (heights[i] <= currHeight) {
        water += currHeight - heights[i++];
      }

      while (heights[j] <= currHeight) {
        water += currHeight - heights[j--];
      }
      currHeight = Math.min(heights[i], heights[j]);
    }
    return water;
  }
}
