package com.lanxu.algorithm;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年09月27 23:55
 **/
public class ClearValue {
  public ListNode clear(ListNode head, int val) {
    if (head == null) {
      return head;
    }
    ListNode cur = head;
    ListNode pre = null;
    while (cur != null) {
      if (cur.val == val) {
        if (cur == head) {
          cur = cur.next;
          head = cur;
        } else {
          cur = cur.next;
          pre.next = cur;
        }
      } else {
        pre = cur;
        cur = cur.next;
      }
    }
    return head;
  }
}