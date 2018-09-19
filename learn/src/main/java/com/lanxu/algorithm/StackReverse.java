package com.lanxu.algorithm;

import com.lanxu.util.JacksonUtils;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年09月19 21:49
 **/
public class StackReverse {

  public int[] reverseStack(int[] a, int n) {
    reverse(a, n - 1);
    return a;
  }

  private void reverse(int[] a, int n) {
    if (n == 0) {
      return;
    }
    int last = getLast(a, n);
    reverse(a, n - 1);
    a[n] = last;
  }

  public int getLast(int[] a, int n) {
    if (n == 0) {
      return a[0];
    }
    int current = a[n--];
    int last = getLast(a, n);
    a[n] = current;
    return last;
  }

  public static void main(String[] args) throws Exception {
    StackReverse stackReverse = new StackReverse();
    int[] a = {1, 2, 3, 4};
    int last = stackReverse.getLast(a, 3);
    System.out.println(JacksonUtils.toJson(a));
    System.out.println(last);
  }
}