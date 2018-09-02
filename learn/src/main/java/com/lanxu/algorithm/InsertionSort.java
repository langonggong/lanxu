package com.lanxu.algorithm;

/**
 * 插入排序
 *
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年09月02 23:05
 **/
public class InsertionSort {
  public int[] insertionSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return arr;
    }

    for (int i=1;i<arr.length;i++) {
      int j = i;
      while (j > 0) {
        if (arr[j - 1] > arr[j]) {
          swap(arr, j, j - 1);
          j--;
        } else {
          break;
        }
      }
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