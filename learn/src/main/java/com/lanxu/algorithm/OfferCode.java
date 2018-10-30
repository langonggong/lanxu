package com.lanxu.algorithm;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年10月22 21:28
 **/
public class OfferCode {
  public ListNode ReverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode a, b, c;
    a = head;
    b = a.next;
    head.next = null;
    while (b != null) {
      c = b.next;
      b.next = a;
      a=b;
      b=c;
    }
    return a;
  }

}