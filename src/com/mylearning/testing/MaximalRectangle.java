package com.mylearning.testing;

import java.util.Stack;

public class MaximalRectangle {

  public static void main(String[] args) {
    int[][] arr = {
        {1, 0, 1, 0, 0},
        {1, 0, 1, 1, 1},
        {1, 1, 1, 1, 1},
        {1, 0, 0, 1, 0}
    };

    int[] heights = new int[arr[0].length];
    int max = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (arr[i][j] == 0) {
          heights[j]  = 0;
        } else {
          heights[j] += 1;
        }
      }
      max = Math.max(max, largestRectangle(heights));
    }
    System.out.println(max);
  }

  private static int largestRectangle(int[] heights) {
    if (heights == null || heights.length == 0) return 0;

    int len = heights.length;
    int[] arr = new int[len + 2];

    for (int i = 0; i < len; i++) {
      arr[i + 1] = heights[i];
    }

    len = len + 2;

    int max = 0;
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    for (int i = 1; i < len; i++) {
      while (arr[i] < arr[stack.peek()]) {
        int height = arr[stack.pop()];
        int width = i - stack.peek() - 1;
        max = Math.max(max, height * width);
      }
      stack.push(i);
    }
    return max;
  }
}
