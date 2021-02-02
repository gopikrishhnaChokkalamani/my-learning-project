package com.mylearning.problems.v1.leetcode.medium;

import java.util.Arrays;

public class IslandsNumberOf {
  
  public static void main(String[] args) {
    char[][] arr = {
        {'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}
    };
    int numOfIslands = 0;
    boolean[][] visited = new boolean[arr.length][arr[0].length];
    //two solutions, 1 with visited array, and another without
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
//        if (arr[i][j] == '1') {
//          numOfIslands += dfs(arr, i, j, visited);
//        }
        if (arr[i][j] == '1' && visited[i][j] == false) {
          dfs_visited(arr, i, j, visited);
          numOfIslands++;
        }
      }
    }
    System.out.println(numOfIslands);
  }
  
  private static void dfs_visited(char[][] arr, int i, int j, boolean[][] visited) {
    if (i < 0 || i >= arr.length || j < 0 || j >= arr[i].length || arr[i][j] == '0' || visited[i][j] == true) {
      return;
    }
    //arr[i][j] = '0';
    visited[i][j] = true;
    dfs_visited(arr, i + 1, j, visited);
    dfs_visited(arr, i - 1, j, visited);
    dfs_visited(arr, i, j + 1, visited);
    dfs_visited(arr, i, j - 1, visited);
    //return 1;
  }
  
  private static int dfs(char[][] arr, int i, int j) {
    if (i < 0 || i >= arr.length || j < 0 || j >= arr[i].length || arr[i][j] == '0') {
      return 0;
    }
    arr[i][j] = '0';
    dfs(arr, i + 1, j);
    dfs(arr, i - 1, j);
    dfs(arr, i, j + 1);
    dfs(arr, i, j - 1);
    return 1;
  }
  
}
