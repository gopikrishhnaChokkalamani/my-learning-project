package com.mylearning.testing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MergeIntervals {

  public static void main(String[] args) {
    int[][] arr = {
        {8, 10},
        {1, 3},
        {15, 18},
        {2, 6}
    };
    Arrays.sort(arr, Comparator.comparing(ints -> ints[0]));
    List<Interval> list = Arrays.stream(arr).map(ints -> new Interval(ints[0], ints[1])).collect(Collectors.toList());
    LinkedList<Interval> l = new LinkedList<>();
    for (Interval i : list) {
      if (l.isEmpty() || l.getLast().end < i.start) l.add(i);
      else l.getLast().end = Math.max(l.getLast().end, i.end);
    }

    int[][] newArr = new int[l.size()][2];
    int i = 0;
    for (Interval inter : l) {
      newArr[i][0] = inter.start;
      newArr[i][1] = inter.end;
      i++;
    }
    System.out.println();
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