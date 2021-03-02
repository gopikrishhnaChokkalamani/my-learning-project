package com.mylearning.problems.v1.hundreddaysalgorithm;

public class Day1_TowersOfHanoi {

  public static void main(String[] args) {
    int disks = 3;
    towerOfHanoi(disks, 'A', 'C', 'B');
  }

  private static void towerOfHanoi(int d, char t1, char t3, char t2) {
    if (d == 0) return;
    towerOfHanoi(d - 1, t1, t2, t3);
    System.out.println("Move Disk " + d + " from " + t1 + " to " + t3);
    towerOfHanoi(d - 1, t2, t3, t1);
  }
}
