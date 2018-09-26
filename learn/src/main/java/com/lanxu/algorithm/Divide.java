package com.lanxu.algorithm;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年09月26 22:23
 **/
public class Divide {
  public ListNode listDivide(ListNode head, int val) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode leftHead = null, leftTail = null, rightHead = null, rightTail = null, cur = head;
    while (cur != null) {
      ListNode tmp = new ListNode(cur.val);
      if (cur.val <= val) {
        if (leftHead == null) {
          leftHead = tmp;
        } else {
          leftTail.next = tmp;
        }
        leftTail = tmp;
      }
      if (cur.val > val) {
        if (rightHead == null) {
          rightHead = tmp;
        } else {
          rightTail.next = tmp;
        }
        rightTail = tmp;
      }
      cur = cur.next;
    }
    leftTail.next = rightHead;
    return leftHead;
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(4);
    ListNode l3 = new ListNode(2);
    ListNode l4 = new ListNode(5);
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;

    Divide divide = new Divide();
    ListNode node = divide.listDivide(l1, 3);
    int a = 1 + 2;
    System.out.println(a);
  }
}