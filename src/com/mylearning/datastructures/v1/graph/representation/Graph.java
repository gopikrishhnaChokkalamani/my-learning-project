package com.mylearning.datastructures.v1.graph.representation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {

  List<List<Integer>> list;
  boolean[] visited;

  public Graph(int n) {
    list = new ArrayList<>();
    visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      list.add(i, new ArrayList<>());
    }
  }

  public void addEdge(int src, int dest) {
    list.get(src).add(dest);
    list.get(dest).add(src);
  }

  public void removeEdge(int src, int dest) {
    list.get(src).remove(dest);
    list.get(dest).remove(src);
  }

  public void dfs(int start) {
    Stack<Integer> stack = new Stack<>();
    stack.push(start);
    visited[start] = true;
    while (!stack.isEmpty()) {
      int node = stack.pop();
      List<Integer> neighbors = list.get(node);
      System.out.print(node + " ");
      for (Integer neighbor : neighbors) {
        if (!visited[neighbor]) {
          stack.push(neighbor);
          visited[neighbor] = true;
        }
      }
    }
    System.out.println();
  }

  public void bfs(int start) {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(start);
    visited[start] = true;
    while (!queue.isEmpty()) {
      int node = queue.remove();
      System.out.print(node + " ");
      List<Integer> neighors = list.get(node);
      for (Integer neighbor : neighors) {
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          queue.add(neighbor);
        }
      }
    }
  }
}