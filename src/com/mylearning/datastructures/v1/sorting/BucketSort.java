package com.mylearning.datastructures.v1.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {
  
  // get number of buckets needed
  // find max element
  // then put elements in buckets based on floor(value * (nbuckets - 1)/max)) - this will make sure elements of same size go in correct bucket
  //sort the buckets
  //merge the buckets
  public static void main(String[] args) {
    int[] arr = {3, 5, 2, 3, 1, 2, 4, 6, 5};
    System.out.println("UN SORTED : " +Arrays.toString(arr));
    int nBuckets = (int) Math.ceil(Math.sqrt(arr.length));
    List<Integer>[] buckets = new ArrayList[nBuckets];
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = new ArrayList<>();
    }
    
    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    for (Integer i : arr) {
      if (max < arr[i]) {
        max = arr[i];
      }
      if (min > arr[i]) {
        min = arr[i];
      }
    }
    
    for (int i = 0; i < arr.length; i++) {
      int bucket = (int) Math.floor((arr[i] * (nBuckets - 1)) / max);
      buckets[bucket].add(arr[i]);
    }
    
    System.out.println("Print buckets BEFORE sorting");
    for (List<Integer> i : buckets) {
      System.out.println(Arrays.toString(i.toArray()));
    }
    
    for (List<Integer> i : buckets) {
      Collections.sort(i);
    }
    
    System.out.println("Print buckets AFTER sorting");
    for (List<Integer> i : buckets) {
      System.out.println( Arrays.toString(i.toArray()));
    }
    
    int index = 0;
    for (List<Integer> list : buckets) {
      for (Integer i : list) {
        arr[index] = i;
        index++;
      }
    }
    System.out.println("AFTER BUCKET MERGE");
    System.out.println("SORTED : " + Arrays.toString(arr));
  }
}
