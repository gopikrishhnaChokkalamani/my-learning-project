package com.mylearning.problems.v1.internet;

import java.util.Arrays;

public class LearningRegex {

  public static void main(String[] args) {
    String s = "A beautiful day, for a nice cup of tea at 5pm in 1985";
    //remove all special characters, except space
    System.out.println(s);
    s = s.replaceAll("[^a-zA-Z0-9 ]", "");
    System.out.println(s);
    //now, get into a string array
    String[] sarr = s.split("\\s");  //except space
    System.out.println(Arrays.toString(sarr));

    //now get only numbers into an array
    String[] nums = s.split("\\d+"); //split at digit location //[A beautiful day for a nice cup of tea at , pm in ]
    System.out.println("d+ " + Arrays.toString(nums)); //[, , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , 5, , , , , , 1985]
    String[] nums1 = s.split("\\D+");
    System.out.println("D+ " + Arrays.toString(nums1));

    String ss = s.replaceAll("[^0-9$]", "");
    System.out.println(ss);

    String para = "Bob hit a ball the hit BALL flew far after it was hit in 1980";
    String[] parr = para.split("\\w+");
    System.out.println("w+ " + Arrays.toString(parr));
    String[] parr1 = para.split("\\W+");
    System.out.println("W+ " + Arrays.toString(parr1));
  }
}
