package com.lanxu.algorithm;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年10月09 22:30
 **/
public class CheckIntersect {

  public boolean chkIntersect(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return false;
    }
    int lengthA = 0, lengthB = 0;
    ListNode cur = headA;
    while (cur != null) {
      lengthA++;
      cur = cur.next;
    }
    cur = headB;
    while (cur != null) {
      lengthB++;
      cur = cur.next;
    }
    int diff = lengthA - lengthB;
    cur = diff > 0 ? headA : headB;
    ListNode other = diff > 0 ? headB : headA;
    for(int i=0;i<diff;i++) {
      cur = cur.next;
    }
    while (cur != null) {
      if (cur == other) {
        return true;
      }
      cur = cur.next;
      other = other.next;
    }
    return false;
  }
}