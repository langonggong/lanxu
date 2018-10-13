package com.lanxu.algorithm;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年09月28 22:23
 **/
public class RandomListNodeClone {

  public RandomListNode Clone(RandomListNode head) {
    if (head == null) {
      return head;
    }
    RandomListNode cur = head;
    while (cur != null) {
      RandomListNode tmp = new RandomListNode(cur.label);
      tmp.next = cur.next;
      cur.next = tmp;
      cur = tmp.next;
    }

    cur = head;
    while (cur != null) {
      RandomListNode randomNext = cur.random;
      if (randomNext == null) {
        cur = cur.next.next;
        continue;
      }
      RandomListNode next = cur.next;
      next.random = randomNext.next;
      cur = cur.next.next;
    }

    RandomListNode res = head.next;
    cur = res;
    while (cur != null && cur.next != null) {
      cur.next = cur.next.next;
      cur = cur.next;
    }

    return res;
  }

  public RandomListNode Clone2(RandomListNode head)
  {

    if (head == null) {
      return null;
    }
    RandomListNode cur = head;
    RandomListNode next = null;
    // copy node and link to every node
    while (cur != null) {
      next = cur.next;
      cur.next = new RandomListNode(cur.label);
      cur.next.next = next;
      cur = next;
    }
    cur = head;
    RandomListNode curCopy = null;
    // set copy node rand
    while (cur != null) {
      next = cur.next.next;
      curCopy = cur.next;
      curCopy.random = cur.random != null ? cur.random.next : null;
      cur = next;
    }
    RandomListNode res = head.next;
    cur = head;
    // split
    while (cur != null) {
      next = cur.next.next;
      curCopy = cur.next;
      cur.next = next;
      curCopy.next = next != null ? next.next : null;
      cur = next;
    }
    return res;

  }

  public static void main(String[] args) {
    RandomListNode n1 = new RandomListNode(1);
    RandomListNode n2 = new RandomListNode(2);
    RandomListNode n3 = new RandomListNode(3);
    RandomListNode n4 = new RandomListNode(4);
    RandomListNode n5 = new RandomListNode(5);

    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;

    n1.random = n3;
    n2.random = n5;
    n4.random = n2;

    RandomListNodeClone randomListNodeClone = new RandomListNodeClone();
    RandomListNode clone = randomListNodeClone.Clone(n1);

    printNode(clone);
//    System.out.println(1);

  }

  private static void printNode(RandomListNode head) {
    RandomListNode cur = head;
    while (cur != null) {
      System.out.println(cur.label);
      cur = cur.next;
    }
    cur = head;
    while (cur != null) {
      System.out.println(cur.random == null ? "null" : cur.random.label);
      cur = cur.next;
    }
  }
}