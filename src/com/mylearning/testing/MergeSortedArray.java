package com.mylearning.testing;

public class MergeSortedArray {

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int[] nums2 = {2, 5, 6};
    int m = 3, n = 3;
    int i = 0, j = 0, k = 0;
    int[] c = new int[m + n];
    while (i < m && j < n) {
      if (nums1[i] < nums2[j]) {
        c[k] = nums1[i];
        i++; k++;
      } else {
        c[k] = nums2[j];
        j++; k++;
      }
    }

    while (i < m) {
      c[k++] = nums1[i++];
    }
    while (j < n) {
      c[k++] = nums2[j++];
    }
    System.out.println();
  }
}
