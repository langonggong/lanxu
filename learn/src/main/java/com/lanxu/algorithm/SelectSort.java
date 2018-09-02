package com.lanxu.algorithm;

/**
 * 选择排序
 *
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年09月02 22:52
 **/
public class SelectSort {

  public int[] selectionSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return arr;
    }
    for (int i = 0; i < arr.length - 1; i++) {
      int mini = i;
      for (int j = i + 1; j < arr.length; j++) {
        mini = arr[j] < arr[mini] ? j : mini;
      }
      swap(arr, i, mini);
    }

    return arr;
  }

  private void swap(int[] arr, int i, int j) {
    if (i == j) {
      return;
    }
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}