package com.lanxu.algorithm;

import com.lanxu.study.effectiveJava.Chapter5.Item28.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年09月17 23:45
 **/
public class TwoStack {

  Stack<Integer> s1 = new Stack<>();
  Stack<Integer> s2 = new Stack<>();

  public int[] twoStack(int[] ope, int n) {
    if (ope == null || ope.length == 0) {
      return new int[0];
    }
    List<Integer> list = new ArrayList<>();
    for (int i : ope) {
      if (i > 0) {
        push(i);
      } else {
        list.add(pop());
      }
    }
    int[] arr = new int[list.size()];
    for(int i=0;i<arr.length;i++) {
      arr[i] = list.get(i);
    }
    return arr;
  }

  private void push(int i) {
    s1.push(i);
  }

  private int pop() {
    if (s1.isEmpty()) {
      return -1;
    }
    while (!s1.isEmpty()) {
      s2.push(s1.pop());
    }

    int result = s2.pop();
    while (!s2.isEmpty()) {
      s1.push(s2.pop());
    }
    return result;
  }
}