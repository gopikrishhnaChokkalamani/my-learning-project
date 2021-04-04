package com.mylearning.problems.v1.leetcode.medium;

public class TicTacToe {

//  ["TicTacToe", "move", "move", "move", "move", "move", "move", "move"]
//      [[3], [0, 0, 1], [0, 2, 2], [2, 2, 1], [1, 1, 2], [2, 0, 1], [1, 0, 2], [2, 1, 1]]
//[null, 0, 0, 0, 0, 0, 0, 1]

  public static void main(String[] args) {
    TicTacToe t = new TicTacToe(3);
    System.out.println(t.move(0, 0, 1));
    System.out.println(t.move(0, 2, 2));
    System.out.println(t.move(2, 2, 1));
    System.out.println(t.move(1, 1, 2));
    System.out.println(t.move(2, 0, 1));
    System.out.println(t.move(1, 0, 2));
    System.out.println(t.move(2, 1, 1));
  }

  private int[][] arr;
  private int size;

  public TicTacToe(int n) {
    this.size = n;
    this.arr = new int[n][n];
  }

  public int move(int row, int col, int player) {
    arr[row][col] = player;
    print(arr);
    if (hasPlayerWon(row, col, player)) return player;
    return 0;
  }

  private void print(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  private boolean hasPlayerWon(int row, int col, int player) {
    boolean byColumn = wonByColumn(player, col);
    boolean byRow = wonByRow(player, row);
    boolean byLeftDiagonal = wonByLeftDiagonal(player);
    boolean byRightDiagonal = wonByRightDiagonal(player);
    return byColumn || byRow || byLeftDiagonal || byRightDiagonal;
  }

  private boolean wonByRightDiagonal(int player) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i][size - i - 1] != player) return false;
    }
    return true;
  }

  private boolean wonByLeftDiagonal(int player) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i][i] != player) return false;
    }
    return true;
  }

  private boolean wonByRow(int player, int row) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[row][i] != player) return false;
    }
    return true;
  }

  private boolean wonByColumn(int player, int col) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i][col] != player) return false;
    }
    return true;
  }
}
