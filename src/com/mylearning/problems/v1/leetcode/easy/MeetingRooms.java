package com.mylearning.problems.v1.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MeetingRooms {

  public static void main(String[] args) {
    int[][] arr = {
        {15, 20},
        {0, 30},
        {5, 10}
    };

    Arrays.sort(arr, Comparator.comparingInt(ints -> ints[0]));

    //easy way
    int prev = arr[0][1];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i][0] < prev) {
        System.out.println("cannot attend - overlapping meetings");
        break;
      }
      prev = arr[i][1];
    }

    //not time and space efficient
    int i = 0;
    List<Meeting> list = Arrays.stream(arr).map(ints -> new Meeting(ints[0], ints[1])).collect(Collectors.toList());
    LinkedList<Meeting> linkedList = new LinkedList<>();
    for (Meeting m : list) {
      if (linkedList.isEmpty() || linkedList.getLast().end <= m.start) {
        linkedList.add(m);
      } else {
        System.out.println("cannot attend");
        break;
      }
    }
  }
}

class Meeting {
  int start;
  int end;

  public Meeting(int start, int end) {
    this.start = start;
    this.end = end;
  }
}