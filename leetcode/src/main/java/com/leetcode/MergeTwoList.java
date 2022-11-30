package com.leetcode;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
public class MergeTwoList {

  public static void main(String[] args) {

  }

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

  }

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (null == list1){
      return list2;
    }
    if (null == list2){
      return list1;
    }
    if (list1.val>list2.val){
      list2.next = mergeTwoLists(list1,list2.next);
      return list2;
    }else {
      list1.next = mergeTwoLists(list1.next,list2);
      return list1;
    }
  }

  public ListNode mergeTwoLists2(ListNode list1, ListNode list2){
    if (null == list1){
      return list2;
    }
    if (null == list2){
      return list1;
    }

    ListNode preHead = new ListNode(-1);
    ListNode movNode =  preHead;
    while (null != list1 && null != list2){
      if (list1.val>=list2.val){
        movNode.next = list2;
        list2 = list2.next;
      }else {
        movNode.next = list1;
        list1 = list1.next;
      }
      movNode = movNode.next;
    }
    movNode.next = list1==null?list2:list1;
    return preHead.next;
  }
}
