package com.mylearning.problems.v1.leetcode.medium;

public class FindTheCelebrity {

  public static void main(String[] args) {
//    int n = 5;
//
//    int possibleCelebrity = 0;
//    for (int i = 1; i < n; i++) {
//      if (knows(possibleCelebrity, i)) {
//        possibleCelebrity = i;
//      }
//    }
//
//    for (int i = 0; i < n; i++) {
//      if (possibleCelebrity == i) continue;
//      if (knows(possibleCelebrity, i) || !knows(i, possibleCelebrity)) {
//        return -1;
//      }
//    }
//    System.out.println(possibleCelebrity);
  }

//  public int findCelebrity(int n) {
//    int candidate = 0;
//    for (int i = 0; i < n; i++) {
//      if (knows(candidate, i)) {
//        candidate = i;
//      }
//    }
//
//    for (int i = 0; i < candidate; i++) {
//      if (knows(candidate, i) || !knows(i, candidate)) {
//        return -1;
//      }
//    }
//
//    for (int i = candidate + 1; i < n; i++) {
//      if (!knows(i, candidate)) {
//        return -1;
//      }
//    }
//    return candidate;
//  }
}
