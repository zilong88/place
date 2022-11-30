package com.leetcode;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class linkedListComponents {
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public int numComponents(ListNode head, int[] nums) {
    Set<Integer> numsSet = new HashSet<>(nums.length);
    for (int n:nums){
      numsSet.add(n);
    }
    int n = 0;
    boolean first = false;
    while (!Objects.isNull(head)){
      if (numsSet.contains(head.val) ){
        if (!first){
          n++;
          first = true;
        }
      }else {
        first = false;
      }
      head = head.next;
    }
    return n;
  }

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> numMap = new HashMap<>(nums.length);
    for (int i=0;i<nums.length;i++){
      int source = target-nums[i];
      Integer index = numMap.get(source);
      if (Objects.nonNull(index)){
        return new int[]{i,index};
      }
      numMap.put(nums[i],i);
    }
    return null;
  }

  public int maxChunksToSorted(int[] arr) {
    int max = 0,num = 0;
    for(int i = 0; i<arr.length ;i++){
      max = Math.max(max,arr[i]);
      if(max == i){
        num++;
      }
    }
    return num;
  }

  public int countStudents(int[] students, int[] sandwiches) {
    int s1 = Arrays.stream(students).sum();
    int s0 = students.length-s1;
    for (int sandwich : sandwiches){
      if (sandwich == 0 && s0>0){
        s0--;
      }else if (sandwich == 1 && s1>0){
        s1--;
      }else {
        break;
      }
    }
    return s0+s1;
  }

  public static void main(String[] args) {
    String a = "";
    byte[] b = a.getBytes(StandardCharsets.UTF_8);
    byte[] b32 = new byte[32];
    System.arraycopy(b,0,b32,0,b.length);
    System.out.println(b32);

  }
}
