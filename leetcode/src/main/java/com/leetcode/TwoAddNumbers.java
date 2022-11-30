package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TwoAddNumbers {

  public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = null;
    ListNode tail = null;
    int carry = 0;
    while (Objects.nonNull(l1) || Objects.nonNull(l2)) {
      int v1 = 0, v2 = 0;
      if (Objects.nonNull(l1)) {
        v1 = l1.val;
        l1 = l1.next;
      }
      if (Objects.nonNull(l2)) {
        v2 = l2.val;
        l2 = l2.next;
      }

      int sum = v1 + v2 + carry;
      if (Objects.isNull(head)) {
        head = tail = new ListNode(sum % 10);
      } else {
        tail.next = new ListNode(sum % 10);
        tail = tail.next;
      }
      carry = sum / 10;
    }
    if (carry > 0) {
      tail.next = new ListNode(carry);
    }
    return head;
  }

  public int arraySign(int[] nums) {
    int negativeNum = 0;
    for (int n : nums) {
      if (n == 0) {
        return 0;
      } else if (n < 0) {
        negativeNum++;
      }
    }
    return negativeNum % 2 == 0 ? 1 : -1;
  }

  public int romanToInt(String s) {
    Map<Character, Integer> map = new HashMap<>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);

    char[] nums = s.toCharArray();
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      int cur = map.get(nums[i]);
      if ((i<nums.length-1) && cur < map.get(nums[i+1])){
          sum = sum-cur;
      }else {
        sum = sum+cur;
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    TwoAddNumbers t = new TwoAddNumbers();
    System.out.println(t.removeElement(new int [] {3,3},3));
  }
  public int removeElement(int[] nums, int val) {
    int tailIndex = nums.length;
    int count = 0;
    for (int i=0;i<tailIndex;i++){
      if (nums[i] == val){
        count++;
        for (int j = tailIndex-1;j>i;j--){
          if (nums[j] != val){
            nums[i] = nums[j];
            tailIndex = j;
            break;
          }
          tailIndex = j;
          count++;
        }
      }
    }

    return nums.length-count;
  }

  public int maxRepeating(String sequence, String word) {
    String tmp = word;
    int res  = 0;
    while (tmp.length()<=sequence.length()){
      if (sequence.contains(tmp)){
        res++;
        tmp = tmp+word;
      }else {
        break;
      }
    }
    return res;
  }
}
