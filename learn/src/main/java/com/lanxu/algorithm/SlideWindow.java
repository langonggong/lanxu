package com.lanxu.algorithm;

import com.lanxu.util.JacksonUtils;

import java.util.LinkedList;

import io.swagger.models.auth.In;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年09月19 22:35
 **/
public class SlideWindow {
  public int[] slide(int[] arr, int n, int w) {
    if (arr == null || arr.length == 0 || arr.length < w) {
      return new int[0];
    }
    LinkedList<Integer> list = new LinkedList<>();
    int[] result = new int[arr.length - w + 1];
    int index = 0;
    for (int i = 0; i < arr.length; i++) {
      //把较小的值挤掉，按照从大到小排序
      while (!list.isEmpty() && arr[list.peekLast()] <= arr[i]) {
        list.pollLast();
      }
      list.addLast(i);
      //不在窗口里面的元素删掉
      if (i - list.peekFirst() == w) {
        list.pollFirst();
      }
      if (i + 1 >= w) {
        result[index++] = arr[list.peekFirst()];
      }
    }
    return result;
  }
}