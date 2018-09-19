package com.lanxu.algorithm;

import com.lanxu.util.JacksonUtils;

import java.util.Stack;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年09月20 00:34
 **/
public class MaxTree {

  public static int[] buildMaxTree(int[] a, int n) {

    Stack<Integer> des = new Stack<>();//栈中的元素按降序排列
    int[] res = new int[a.length];
    for (int i = 0; i < a.length; i++) {
      res[i] = -1;
    }
    for (int i = 0; i < a.length; i++) {
      //左边的元素小于当前元素
      while (!des.isEmpty() && a[des.peek()] < a[i]) {
        //如果元素(i-1)的左边为空或者元素(i-1)左边第一个大的元素大于当前元素
        if (res[des.peek()] == -1 || a[res[des.peek()]] > a[i]) {
          res[des.peek()] = i;
        }
        des.pop();
      }
      if (!des.isEmpty()) {
        res[i] = des.peek();
      }
      des.push(i);
    }
    return res;

  }

  public static void main(String[] args) throws Exception {
    int[] arr = {3, 1, 4, 2};
    int[] maxTree = buildMaxTree(arr, 4);
    System.out.println(JacksonUtils.toJson(maxTree));
  }
}