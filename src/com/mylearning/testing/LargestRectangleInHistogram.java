package com.mylearning.testing;

import java.util.Stack;

public class LargestRectangleInHistogram {

  public static void main(String[] args) {
    int[] heights = {2, 1, 5, 6, 2, 3};
    System.out.println(largestRectangle(heights));
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
