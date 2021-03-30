package com.mylearning.problems.v1.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsInANetwork {

  /**
   * Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
   * Output: [[1,3]]
   * Explanation: [[3,1]] is also accepted.
   */

  public static void main(String[] args) {
    List<List<Integer>> list = criticalConnections(4, Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 2),
        Arrays.asList(2, 0), Arrays.asList(1, 3)));
  }

  static List<List<Integer>> adjacencyList = new ArrayList<>();
  static int[] visitedTimes;
  static int[] lowTimes;
  static int times = 0;
  static List<List<Integer>> criticalConnections = new ArrayList<>();

  public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    buildGraph(n, connections);
    boolean[] visited = new boolean[n];
    visitedTimes = new int[n];
    lowTimes = new int[n];
    dfs(0, visited, 0);
    return criticalConnections;
  }

  private static void dfs(int start, boolean[] visited, int parent) {
    visited[start] = true;
    visitedTimes[start] = lowTimes[start] = times++;
    System.out.print(start + " ");
    for (Integer neighbor : adjacencyList.get(start)) {
      if (neighbor == parent) continue;
      if (!visited[neighbor]) {
        visited[neighbor] = true;
        dfs(neighbor, visited, start);
        lowTimes[start] = Math.min(lowTimes[start], lowTimes[neighbor]);
        if (visitedTimes[start] < lowTimes[neighbor]) {
          criticalConnections.add(Arrays.asList(start, neighbor));
        }
      } else {
        lowTimes[start] = Math.min(lowTimes[start], visitedTimes[neighbor]);
      }
    }
  }

  private static void buildGraph(int n, List<List<Integer>> connections) {
    for (int i = 0; i < n; i++) {
      adjacencyList.add(i, new ArrayList<>());
    }

    for (List<Integer> l : connections) {
      int src = l.get(0);
      int dest = l.get(1);
      adjacencyList.get(src).add(dest);
      adjacencyList.get(dest).add(src);
    }
  }
}
