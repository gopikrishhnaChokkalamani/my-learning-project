package com.mylearning.problems.v1.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class MergeIntervalsArray {
  
  public static void main(String[] args) {
    int[][] arr = {
        {15, 18},
        {2, 6},
        {1, 3},
        {8, 10}
    };
  
    //sort array in place
    //Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
    //Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
  
    List<Interval> list = Arrays.stream(arr).map(ints -> new Interval(ints[0], ints[1])).collect(Collectors.toCollection(LinkedList::new));
    
//    for (int[] a : arr) {
//      list.add(new Interval(a[0], a[1]));
//    }
    Collections.sort(list, Comparator.comparingInt(a -> a.start));
    
    LinkedList<Interval> l = new LinkedList<>();
    for (Interval i : list) {
      if (l.isEmpty() || l.getLast().end < i.start) {
        l.add(i);
      } else {
        l.getLast().end = Math.max(i.end, l.getLast().end);
      }
    }
    
    int[][] res = new int[l.size()][2];
    int i = 0;
    for (Interval interval : l) {
      res[i][0] = interval.start;
      res[i][1] = interval.end;
      i++;
    }
    
    //Collections.sort(list, (a, b) -> a.start - b.start); - ascending
   // Collections.sort(list, (a, b) -> b.start - a.start); - desencding
    
    System.out.println();
    
    //another method
    anotherMethod();
    another(arr);
  }

  private static void another(int[][] arr) {
    if (arr == null || arr.length == 0) return;

    Arrays.sort(arr, Comparator.comparing(ints -> ints[0]));
    int[] prev = arr[0];
    List<int[]> list = new ArrayList<>();

    for (int i = 1; i < arr.length; i++) {
      int prevLast = prev[1];
      int prevFirst = prev[0];
      int[] curr = arr[i];
      int currFirst = curr[0];
      int currLast = curr[1];
      if (prevLast >= currFirst) {
        currFirst = Math.min(currFirst, prevFirst);
        currLast = Math.max(prevLast, currLast);
      }
      list.add(new int[]{currFirst, currLast});
    }
    System.out.println();
  }

  private static void anotherMethod() {
    int[][] arr = {
        {15, 18},
        {2, 6},
        {1, 3},
        {8, 10}
    };
    
    Arrays.sort(arr, Comparator.comparingInt(ints -> ints[0]));
    
    List<int[]> list = new ArrayList<>();
    int[] curr_interval = arr[0];
    list.add(curr_interval);
    
    for (int[] interval : arr) {
      int curr_start = curr_interval[0];
      int curr_end = curr_interval[1];
      int next_start = interval[0];
      int next_end = interval[1];
      if (curr_end > next_start) {
        curr_interval[1] = Math.max(curr_end, next_end);
      } else {
        curr_interval = interval;
        list.add(curr_interval);
      }
    }
    
    int[][] res = list.toArray(new int[list.size()][]);
    
  }
}

class Interval {
  int start;
  int end;
  
  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
}
