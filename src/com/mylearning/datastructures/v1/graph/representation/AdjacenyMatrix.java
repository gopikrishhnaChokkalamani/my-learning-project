package com.mylearning.datastructures.v1.graph.representation;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class AdjacenyMatrix {

  public static void main(String[] args) {
    int[][] arr = {
        {0, 1, 1, 0},
        {1, 0, 1, 1},
        {1, 1, 0, 0},
        {0, 1, 0, 0}
    };

   bfs(arr, 0, arr.length);
   dfs(arr, 0, arr.length);
  }

  private static void dfs(int[][] arr, int start, int v) {
    boolean[] visited = new boolean[v];
    Stack<Integer> stack = new Stack<>();
    stack.push(start);
    visited[start] = true;
    while (!stack.isEmpty()) {
      int node = stack.pop();
      System.out.print(node + " ");
      for (int i = 0; i < v; i++) {
        if (arr[node][i] == 1 && !visited[i]) {
          stack.push(i);
          visited[i] = true;
        }
      }
    }
    System.out.println();
  }

  private static void bfs(int[][] arr, int start, int v) {
    boolean[] visited = new boolean[v];
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(start);
    visited[start] = true;
    while (!queue.isEmpty()) {
      int node = queue.remove();
      System.out.print(node + " ");
      for (int i = 0; i < v; i++) {
        if (arr[node][i] == 1 && !visited[i]) {
          queue.add(i);
          visited[i] = true;
        }
      }
    }
    System.out.println();
  }
}
