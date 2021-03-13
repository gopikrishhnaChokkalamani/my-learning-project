package com.mylearning.problems.v1.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom2 {

  public static void main(String[] args) {
    int[][] arr = {
        {2, 11},
        {6, 16},
        {11, 16}
    };

    Arrays.sort(arr, Comparator.comparingInt(ints -> ints[0]));
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int prev = arr[0][1];
    int rooms = 1;
    for (int i = 0; i < arr.length; i++) {
      if (!queue.isEmpty() && arr[i][0] >= queue.peek()) {
        queue.poll();
      }
        queue.add(arr[i][1]);
    }
    System.out.println(queue.size());
    another(arr);
    anotherMethod(arr);
  }

  private static void anotherMethod(int[][] arr) {
    Arrays.sort(arr, Comparator.comparingInt(ints -> ints[0]));

    PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    queue.add(arr[0]);
    for (int i = 1; i < arr.length; i++) {
      int[] curr = arr[i];
      int[] prev = queue.remove();
      if (curr[0] < prev[1]) {
        queue.add(curr);
        queue.add(prev);
      } else {
        prev[1] = curr[1];
        queue.add(prev);
      }
    }
    System.out.println(queue.size());
  }

  private static void another(int[][] arr) {
    int[] start = new int[arr.length];
    int[] end = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
      start[i] = arr[i][0];
      end[i] = arr[i][1];
    }

    Arrays.sort(start); Arrays.sort(end);

    int rooms = 0, j = 0;
    for (int i = 0; i < arr.length; i++) {
      if (start[i] < end[j]) {
        rooms++;
      } else {
        j++;
      }
    }
    System.out.println(rooms);
  }
}
