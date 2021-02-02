package com.mylearning.problems.v1.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumArrayIsSorted {
  
  public static void main(String[] args) {
    //int[] arr = {2, 3, 4};
    int[] arr = {2, 7, 11, 15};
    int sum = 9;
    int[] res = new int[2];
    
    //one way but space used!!!
//    Map<Integer, Integer> map = new HashMap<>();
//    for (int i = 0; i < arr.length; i++) {
//      int diff = sum - arr[i];
//      if (map.containsKey(diff)) {
//        res[0] = map.get(diff) + 1;
//        res[1] = i + 1;
//        break;
//      } else {
//        map.put(arr[i], i);
//      }
//    }
//    System.out.println(Arrays.toString(arr));
//    System.out.println(Arrays.toString(res));
    
    int i = 0, j = arr.length - 1;
    while (i <= j) {
      if (arr[i] + arr[j] == sum) {
        res[0] = i + 1;
        res[1] = j + 1;
        break;
      } else if (arr[i] + arr[j] > sum) {
        j--;
      } else {
        i++;
      }
    }
        System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(res));
  }
}
