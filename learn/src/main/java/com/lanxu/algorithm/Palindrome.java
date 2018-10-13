package com.lanxu.algorithm;


import java.util.Stack;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年09月28 22:12
 **/
public class Palindrome {

  public boolean isPalindrome(ListNode pHead) {
    if (pHead == null) {
      return false;
    }
    Stack<Integer> stack = new Stack<>();
    ListNode cur = pHead;
    while (cur != null) {
      stack.push(cur.val);
      cur = cur.next;
    }
    cur = pHead;
    while (!stack.isEmpty()) {
      if (stack.pop() != cur.val) {
        return false;
      }
      cur = cur.next;
    }
    return true;
  }
}