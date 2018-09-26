package com.lanxu.algorithm;

import java.util.ArrayList;
import java.util.List;

import io.swagger.models.auth.In;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年09月26 23:43
 **/
public class Common {

  public int[] findCommonParts(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return new int[0];
    }
    List<Integer> list = new ArrayList<>();
    while (headA != null && headB != null) {
      if (headA.val < headB.val) {
        headA = headA.next;
      } else if (headA.val == headB.val) {
        list.add(headA.val);
        headA = headA.next;
        headB = headB.next;
      } else {
        headB = headB.next;
      }
    }
    int[] result = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      result[i] = list.get(i);
    }
    return result;
  }
}