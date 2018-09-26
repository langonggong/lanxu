package com.lanxu.algorithm;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年09月25 21:58
 **/
public class InsertValue {

  public ListNode insert(int[] arr, int[] next, int val) {
    if (arr == null || arr.length < 1) {
      return null;
    }
    ListNode head = new ListNode(arr[0]);
    ListNode tail = head;
    for (int i = 0; i < next.length - 1; i++) {
      ListNode p = new ListNode(arr[next[i]]);
      tail.next = p;
      tail = tail.next;
    }
    if (val <= head.val) {
      ListNode p = new ListNode(val);
      p.next = head;
      return p;
    }
    ListNode before = head;
    ListNode after = before.next;
    while (after != null) {
      if (val >= Math.min(before.val, after.val) && val <= Math.max(before.val, after.val)) {
        break;
      }
      before = after;
      after = after.next;
    }
    ListNode cur = new ListNode(val);
    cur.next = after;
    before.next = cur;
    return head == after ? cur : head;
  }

  public ListNode insert2(int[] A, int[] nxt, int val) {
    if (A == null || A.length == 0) {
      ListNode t = new ListNode(val);
      return t;

    }

    ListNode head = new ListNode(A[0]);
    ListNode r = head;
    ListNode p;
    for (int i = 0; i < nxt.length - 1; i++) {
      p = new ListNode(A[nxt[i]]);
      r.next = p;
      r = p;
    }

    ListNode pos = head;
    ListNode pas = head.next;
    while (pas != null) {
      if (val >= pos.val && val <= pas.val)
        break;
      pos = pas;
      pas = pas.next;
    }
    ListNode t = new ListNode(val);
    t.next = pas;
    pos.next = t;
    if (val < head.val)
      return t;
    else
      return head;

  }

  public static void main(String[] args) {
    int[] arr = {4, 8, 9};
    int[] next = {1, 2, 0};
    int val = 1;
    InsertValue insertValue = new InsertValue();
    ListNode head = insertValue.insert(arr, next, val);
    System.out.println();
  }
}