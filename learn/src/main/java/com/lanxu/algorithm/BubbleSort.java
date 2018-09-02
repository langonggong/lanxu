package com.lanxu.algorithm;

/**
 * 冒泡排序
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年09月02 22:44
 **/
public class BubbleSort {

  public int[] bubbleSort(int[] arr, int n) {
    if (arr == null || arr.length < 2) {
      return arr;
    }
    for (int i=arr.length-1;i>0;i--) {
      for (int j=0;j<i;j++) {
        if (arr[j] > arr[j + 1]) {
          swap(arr, j, j + 1);
        }
      }
    }
    return arr;
  }

  private void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}