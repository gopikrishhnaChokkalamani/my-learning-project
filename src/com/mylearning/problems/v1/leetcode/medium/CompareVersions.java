package com.mylearning.problems.v1.leetcode.medium;

public class CompareVersions {

  public static void main(String[] args) {
    String version1 = "1.01", version2 = "1.001";

    System.out.println(compareVersions(version1, version2));
  }


  //O(N + M);
  private static int compareVersions(String version1, String version2) {
    String[] v1 = version1.split("\\.");
    String[] v2 = version2.split("\\.");

    int n = v1.length > v2.length ? v1.length : v2.length;

    for (int i = 0; i < n; i++) {
      int a = i < v1.length ? Integer.parseInt(v1[i]) : 0;
      int b = i < v2.length ? Integer.parseInt(v2[i]) : 0;

      if (a > b) return 1;
      if (a < b) return -1;
    }
    return 0;
  }
}
