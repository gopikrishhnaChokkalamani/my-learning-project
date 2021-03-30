package com.mylearning.testing;

public class NumberOfIslands {

  public static void main(String[] args) {
    char[][] arr = {
        {'1','1','0','0','0'},
        {'1','1','0','0','0'},
        {'0','0','1','0','0'},
        {'0','0','0','1','1'}
    };

    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (arr[i][j] == '1') {
          count += isCompleteIsland(arr, i, j);
        }
      }
    }
    System.out.println(count);
  }

  private static int isCompleteIsland(char[][] arr, int row, int col) {
    if (row < 0 || row > arr.length - 1 || col < 0 || col > arr.length - 1 || arr[row][col] == '0') {
      return 0;
    }
    arr[row][col] = '0';
    isCompleteIsland(arr, row + 1, col);
    isCompleteIsland(arr, row, col + 1);
    //isCompleteIsland(arr, row + 1, col + 1);
    return 1;
  }
}
