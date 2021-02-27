package com.mylearning.problems.v1.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
  
 /*
  The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
  Given an integer n, return all distinct solutions to the n-queens puzzle.
  Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
  
  Input: n = 4
  Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
  Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
  */
  
  public static void main(String[] args) {
    int n = 4;
    int[][] arr = new int[n][n];
    List<List<String>> sol = new ArrayList<>();
    boolean is = nQueens(n, arr, 0, 0, sol);
    //boolean is1 = anotherNQueens(n, arr, 0, 0, sol);
    System.out.println();
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
    int i = 0;
  }
  
//  private static boolean anotherNQueens(int n, int[][] arr, int row, int col, List<List<String>> sol) {
//    if (col >= n || row >= n) {
//      return true;
//    }
//    boolean isValid = false;
//    if (checkPlacement(n, arr, row, col)) {
//      arr[row][col] = 1;
//      isValid = anotherNQueens(n, arr, row, col + 1, sol);
//      if (isValid) {
//        System.out.print("(" + row + ", " + col + ")" + " ");
//      } else {
//        arr[row][col] = 0;
//      }
//    }
//    isValid = anotherNQueens(n, arr, row + 1, col, sol);
//    return isValid;
//  }
  
  private static boolean nQueens(int n, int[][] arr, int row, List<List<String>> sol) {
  
    for (int col = 0; col < n; col++) {
      if (checkBoundingFunction(arr, row, col)) {
        arr[row][col] = 1;
        if (nQueens(n, arr, row + 1, sol)) {
          System.out.print("(" + row + ", " + col + ")" + " ");
        }
      }
    }
    return false;
  }
  
  private static boolean checkBoundingFunction(int[][] arr, int row, int col) {
    for (int i = 0; i < row; i++) {
      if (arr[row][i] == 1) {
        return false;
      }
    }
    
    for (int i = row, j = col; i >= 0 && j >= 0;i--, j--) {
      if (arr[i][j] == 1) {
        return false;
      }
    }
    
    for (int i = row, j = col; i >= 0 && j >= 0;i++, j--) {
      if (arr[i][j] == 1) {
        return false;
      }
    }
    return true;
  }
  
  
  
  
  
  
  
  private static boolean nQueens(int n, int[][] arr, int row, int col, List<List<String>> sol) {
    if (col >= n) {
      return true;
    }
    for (int i = 0; i < n; i++) {
      if (boundingFunction(n, arr, i, col)) {
        arr[i][col] = 1;
        if (nQueens(n, arr, i, col + 1, sol) == true) {
          System.out.print("(" + i + ", " + col + ")" + " ");
          int ih = 0;
          return true;
        }
        arr[i][col] = 0;
      }
    }
    return false;
  }
  
  private static boolean boundingFunction(int n, int[][] arr, int row, int col) {
    // check row and col
    for (int i = 0; i < col; i++) {
      if (arr[row][i] == 1) return false;
    }
    //check diagonal - consider left upper and left lower, right is not needed since no element
    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (arr[i][j] == 1) return false;
    }
    for (int i = row, j = col; j >= 0 && i < n; i++, j--) {
      if (arr[i][j] == 1) return false;
    }
    return true;
  }
}
