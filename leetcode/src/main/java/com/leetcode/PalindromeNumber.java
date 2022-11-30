package com.leetcode;

/**
 * https://leetcode.cn/problems/palindrome-number/?favorite=ex0k24j
 * 回文数
 */
public class PalindromeNumber {

  public static void main(String[] args) {

    PalindromeNumber test = new PalindromeNumber();
    System.out.println( test.palindrome(123));
  }

  public boolean palindrome(int x){
    if (x<0){
      return false;
    }
    if (x<10){
      return true;
    }
    // 最后一位为0 不是回文数
    if ( x %10 == 0){
      return false;
    }

    int tmp = 0;
    while (x > tmp){
      tmp = tmp *10 + x %10;
      x = x/10;
    }

    return x == tmp || x == tmp/10;
  }

}
