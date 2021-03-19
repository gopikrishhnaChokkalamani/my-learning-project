package com.mylearning.problems.v1.leetcode.hard;

import java.util.*;

public class EmployeeFreeTime {

  static class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
      start = _start;
      end = _end;
    }
  }

  public static void main(String[] args) {
    List<List<Interval>> list = new ArrayList<>();
    
    //input
    List<Interval> emp1 = new ArrayList<>();
    emp1.add(new Interval(1, 2));
    emp1.add(new Interval(5, 6));

    List<Interval> emp2 = new ArrayList<>();
    emp2.add(new Interval(1, 3));

    List<Interval> emp3 = new ArrayList<>();
    emp3.add(new Interval(4, 10));

    list.add(emp1);
    list.add(emp2);
    list.add(emp3);

    List<Interval> result = employeeFreeTime(list);
    System.out.println();
  }

  private static List<Interval> employeeFreeTime(List<List<Interval>> list) {
    if (list == null || list.size() == 0) return new ArrayList<>();

    List<Interval> intervals = new ArrayList<>();

    for (List<Interval> i : list) {
      intervals.addAll(i);
    }

    Collections.sort(intervals, Comparator.comparing(interval -> interval.start));

    List<Interval> result = new ArrayList<>();

    int end = intervals.get(0).end;
    for (Interval curr : intervals) {
      if (curr.start <= end) {
        end = Math.max(end, curr.end);
      } else {
        result.add(new Interval(end, curr.start));
        end = curr.end;
      }
    }

    return result;
  }
}
