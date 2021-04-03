package com.mylearning.problems.v1.leetcode.challenges;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestUniqueNumber {

  public static void main(String[] args) {
    int[] arr = {5,7,3,9,4,9,8,3,1};

    //O(n) & O(n)
    Map<Integer, Integer> map = new HashMap<>();
    for (Integer i : arr) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }

    int result = -1;
    for (Integer i : arr) {
      if (map.get(i) == 1) {
        result = Math.max(result, i);
      }
    }
    System.out.println(result);
    //    Usually, you would want to use a hashmap. The solution above exploits the fact that the integers in the input
    //    are between 0 and 1000. If the integers can be as large as 2 ** 31, the array approach would not work
    //    efficiently as that would take too much space.
    // but according to leetcode this solution runs in 0ms
    System.out.println(anotherWay(arr));
  }

  private static int anotherWay(int[] A) {
    int[] count = new int[1001];
    for (int n : A)
    {
      count[n]++;
    }

    for (int i = count.length - 1; i >= 0; --i)
    {
      if (count[i] == 1)
      {
        return i;
      }
    }
    return -1;
  }
}
