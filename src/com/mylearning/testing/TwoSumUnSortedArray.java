package com.mylearning.testing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumUnSortedArray {

  public static void main(String[] args) {
    int[] arr = {2, 7, 11, 15};
    int target = 9;
    System.out.println(Arrays.toString(twoSum(arr, target)));
  }

  private static int[] twoSum(int[] arr, int target) {
    if (arr == null || arr.length == 0) return arr;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (!map.containsKey(arr[i])) map.put(target - arr[i], i);
      else return new int[]{map.get(arr[i]), i};
    }
    return null;
  }
}
