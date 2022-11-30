package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 1306. 跳跃游戏 III
 * BFS 广度优先算法
 */
public class JumpGameiii {

  public static void main(String[] args) {
    JumpGameiii t = new JumpGameiii();
    int [] ary = {4,2,3,0,3,1,2};
    int start = 0;
    System.out.println(t.canReach(ary,start));
  }

  public boolean canReach(int[] arr, int start) {
    //记录索引
    Queue<Integer> subscriptQuery = new LinkedList<>();
    //到达索引
    Set<Integer> visited = new HashSet<>(arr.length);

    subscriptQuery.offer(start);
    while (!subscriptQuery.isEmpty()){
      Integer index = subscriptQuery.poll();
      if (visited.contains(index) || index<0 || index>=arr.length){
        continue;
      }
      visited.add(index);
      if (arr[index] == 0){
        return true;
      }
      subscriptQuery.offer(index+arr[index]);
      subscriptQuery.offer(index-arr[index]);
    }

    return false;
  }

  public int minOperations(String[] logs) {
    int n = 0;
    for(String log : logs){
      switch(log){
        case "./":
          break;
        case "../":
          Math.max(--n,0);
          break;
        default:
          n++;
      }
    }
    return n;
  }
}
