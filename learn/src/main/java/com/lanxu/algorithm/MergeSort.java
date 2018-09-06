package com.lanxu.algorithm;

/**
 * 归并排序
 *
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年09月03 20:57
 **/
public class MergeSort {
  public int[] mergeSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return arr;
    }
    divide(arr, 0, arr.length - 1);
    return arr;
  }

  private void divide(int[] arr, int left, int right) {
    if (left >= right) {
      return;
    }
    int mid = (left + right) / 2;
    divide(arr, left, mid);
    divide(arr, mid + 1, right);
    merge(arr, left, mid, right);
  }

  private void merge(int[] arr, int left, int mid, int right) {
    int[] result = new int[right - left + 1];
    int i = left, j = mid + 1, index = 0;
    while (i <= mid && j <= right) {
      if (arr[i] < arr[j]) {
        result[index++] = arr[i++];
      } else {
        result[index++] = arr[j++];
      }
    }
    while (i <= mid) {
      result[index++] = arr[i++];
    }
    while (j <= right) {
      result[index++] = arr[j++];
    }
    for(int k=0;k<result.length;k++) {
      arr[left + k] = result[k];
    }
  }
}