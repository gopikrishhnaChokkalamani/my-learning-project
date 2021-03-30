package com.mylearning.testing;

public class SearchInsertPosition {

  public static void main(String[] args) {
    int[] arr = {1, 3, 5, 6};
    int t = 7;  //2  //5
    System.out.println(searchPosition(arr, t));
  }

  private static int searchPosition(int[] arr, int t) {
    if (arr == null || arr.length == 0) return 0;
    int j = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == t) return i;
      else if (arr[i] > t) return i;
    }
    return arr.length;
  }
}
