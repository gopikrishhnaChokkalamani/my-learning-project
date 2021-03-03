package com.mylearning.problems.v1.leetcode.hard;

import java.util.Stack;

public class MaximalRectangle {

  //Maximum Sum Rectangle in a 2D Matrix

  public static void main(String[] args) {
    char[][] matrix = {
        {'1', '0', '1', '0', '0'},
        {'1', '0', '1', '1', '1'},
        {'1', '1', '1', '1', '1'},
        {'1', '0', '0', '1', '0'}
    };
    System.out.println(maximalRectangle(matrix));
  }

  public static int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0) return 0;
    int[] heights = new int[matrix[0].length];
    int max = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == '0') {
          heights[j] = 0;
        } else {
          heights[j] += 1;
        }
      }
      max = Math.max(max, findRectangleArea(heights));
    }
    return max;
  }

  private static int findRectangleArea(int[] heights) {
    if (heights.length == 0) return 0;
    int area = 0;
    int n = heights.length;
    int[] arr = new int[n + 2];
    for (int i = 0; i < n; i++) {
      arr[i + 1] = heights[i];
    }
    n = n + 2;
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    for (int i = 1; i < n; i++) {
      while (arr[i] < arr[stack.peek()]) {
        int height = arr[stack.pop()];
        int width = i - stack.peek() - 1;
        area = Math.max(area, width * height);
      }
      stack.push(i);
    }
    return area;
  }
}
