package com.lanxu.algorithm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 两数相加
 *
 * @url https://leetcode-cn.com/problems/add-two-numbers/description/
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年08月25 17:09
 **/
public class AddTwoNumbers {
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(-1);
    ListNode head1 = l1,head2 = l2,cur=head;
    int carry = 0;
    while (head1 != null || head2 != null || carry > 0) {
      int value = carry;
      value += head1 == null ? 0 : head1.val;
      value += head2 == null ? 0 : head2.val;
      if (head1 != null) head1=head1.next;
      if (head2 != null) head2 = head2.next;
      cur.next = new ListNode(value % 10);
      cur = cur.next;
      carry = value / 10;
    }
    return head.next;
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(5);
    ListNode l4 = new ListNode(5);

    ListNode result = addTwoNumbers(l1, l4);

    while (result != null) {
      System.out.println(result.val);
      result = result.next;
    }
  }

}