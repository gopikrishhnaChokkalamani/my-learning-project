package com.mylearning.problems.v1.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LargestRectangleInHistogram {

  public static void main(String[] args) {
    int[] heights = {2, 1, 5, 6, 2, 3};
    System.out.println(largestRectangleArea(heights));
  }

  public static int largestRectangleArea(int[] heights) {
    if (heights == null || heights.length == 0) return 0;
    if (heights.length == 1) return heights[0];

    int area = 0;
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    int len = heights.length;
    int[] arr = new int[len+ 2];
    for (int i = 0; i < len; i++) {
      arr[i + 1] = heights[i];
    }
    len = len + 2;

    for (int i = 1; i < len; i++) {
      while (arr[i] < arr[stack.peek()]) {
        int height = arr[stack.pop()];
        int width = i - stack.peek() - 1;
        area = Math.max(area, height * width);
      }
      stack.push(i);
    }

    return area;
  }

  public static int largestRectangleArea1(int[] heights) {
    int len = heights.length;
    int area = 0;
    if(len == 0) return 0;
    if(len == 1) return heights[0];

    Deque<Integer> stack = new ArrayDeque<>();
    int[] newHeights = new int[len + 2];
    for(int i = 0; i < len; i++){
      newHeights[i+1] = heights[i];
    }
    len = len + 2;

    stack.addLast(0);

    for(int i = 1; i < len; i++){
      while(newHeights[i] < newHeights[stack.peekLast()]){
        int height = newHeights[stack.removeLast()];
        int wideth = i - stack.peekLast() - 1;
        area = Math.max(area, height*wideth);
      }
      stack.addLast(i);
    }
    return area;
  }
}



