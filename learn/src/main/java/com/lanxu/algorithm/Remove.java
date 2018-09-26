package com.lanxu.algorithm;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年09月25 22:53
 **/
public class Remove {

  public ListNode removeNode(ListNode pNode, int delVal) {
    if (pNode == null) {
      return null;
    }
    if (pNode.val == delVal) {
      return pNode.next;
    }
    ListNode before = pNode;
    ListNode after = before.next;
    while (after != null && after.val != delVal) {
      before = after;
      after = after.next;
    }
    if (after == null) {
      return pNode;
    }
    before.next = after.next;
    return pNode;
  }

}