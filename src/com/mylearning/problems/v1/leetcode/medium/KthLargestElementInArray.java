package com.mylearning.problems.v1.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInArray {
  
  public static void main(String[] args) {
    //int[] arr = {3, 2, 1, 5, 6, 4};
    int[] arr = {3,2,3,1,2,4,5,5,6};
    int k = 4;
    Queue<Integer> queue = new PriorityQueue<>();
    for (Integer i : arr) {
        queue.add(i);
      if (queue.size() > k) {
        queue.remove();
      }
    }
    int i = 0;
    System.out.println(queue.remove());
    another(arr, k);
  }

  private static void another(int[] arr, int k) {
    if (arr == null || arr.length == 0) return;
    Arrays.sort(arr);
    for (int i = arr.length - 1; i >= 0; i--) {
      if (arr.length - i == k) {
        System.out.println(arr[i]); break; }
    }
  }
}
