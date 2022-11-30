package com.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Parentheses {

  public static void main(String[] args) {
    Parentheses parentheses = new Parentheses();
    System.out.println(parentheses.isValid("[()]"));
  }

  public boolean isValid(String s) {
    int n = s.length();
    if (n % 2 != 0) {
      return false;
    }
    Map<Character,Character> pairs = new HashMap<>();
    pairs.put(')', '(');
    pairs.put(']', '[');
    pairs.put('}', '{');
    Deque<Character> stack = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (pairs.containsKey(ch)) {
        if (stack.isEmpty() || stack.pop() != pairs.get(ch)) {
          return false;
        }
      } else if (pairs.containsValue(ch)){
        stack.push(ch);
      }else {
        return false;
      }
    }
    return stack.isEmpty();
  }


}
