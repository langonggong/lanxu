package com.lanxu.algorithm;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年09月27 22:39
 **/
public class KInverse {
  public ListNode inverse(ListNode head, int k) {
    if (head == null || head.next == null || k < 2) {
      return head;
    }
    int count = 1;
    ListNode newHead = null;
    ListNode left, right, start = null, end, cur = head;

    while (cur != null) {
      if (count == k) {
        if (newHead == null) {
          left = null;
          start = head;
          newHead = cur;
        } else {
          left = start;
          start = start.next;
        }
        end = cur;
        right = cur.next;
        cur = cur.next;
        inversePart(left, right, start, end);
        count = 1;
      } else {
        cur = cur.next;
        count++;
      }
    }

    return newHead;
  }

  private void inversePart(ListNode left, ListNode right, ListNode start, ListNode end) {
    ListNode pre = start;
    ListNode cur = pre.next;
    ListNode next = cur.next;
    while (cur != right) {
      cur.next = pre;
      pre = cur;
      cur = next;
      if (next != null) {
        next = next.next;
      }
    }
    if (left != null) {
      left.next = end;
    }
    start.next = right;
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(0);
    ListNode l2 = new ListNode(1);
    ListNode l3 = new ListNode(2);
    ListNode l4 = new ListNode(5);
    ListNode l5 = new ListNode(11);

    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = l5;

    int k = 2;

    KInverse kInverse = new KInverse();
    ListNode head = kInverse.inverse(l1, k);
    System.out.println(1);

  }
}