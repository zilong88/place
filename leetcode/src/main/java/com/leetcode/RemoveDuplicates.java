package com.leetcode;

public class RemoveDuplicates {

  public static void main(String[] args) {
    int [] nums = {1,2,3,3};
    RemoveDuplicates removeDuplicates = new RemoveDuplicates();
    System.out.println(removeDuplicates.removeDuplicates(nums));
  }
  public int removeDuplicates(int[] nums){
    int n = nums.length;
    if (n == 0){
      return 0;
    }
    n = n-1;
    int index = 0;
    for (int i = 0;i<n;i++){
      if (nums[i] != nums[i+1]){
        nums[index] =nums[i];
        index = index+1;
        nums[index] = nums[i+1];
      }
    }
    return index+1;
  }

}
