package com.mylearning.testing;

import java.util.Arrays;

public class MergeSortedArray {

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 0, 0, 0, 0};
    int[] nums2 = {2, 5, 6, 8};
    int m = 3, n = 4;
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
    System.out.println(Arrays.toString(c));
    anotherWay(nums1, nums2, m, n);
  }

  private static void anotherWay(int[] nums1, int[] nums2, int m, int n) {
    int i = m - 1, j = n - 1, k = m + n - 1;
    while (i >= 0 && j >= 0) {
      if (nums1[i] < nums2[j]) {
        nums1[k] = nums2[j];
        k--; j--;
      } else {
        nums1[k] = nums1[i];
        k--; i--;
      }
    }
    //if input nums1 > 0 and nums2 is emtpy
    while (j >= 0) {
      nums1[k] = nums2[j];
      k--; j--;
    }
    System.out.println(Arrays.toString(nums1));
  }
}
