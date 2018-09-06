package com.lanxu.algorithm;

/**
 * 计数排序
 *
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年09月05 23:31
 **/
public class CountingSort {

  public int[] countingSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return arr;
    }
    int min = arr[0], max = arr[0];
    for(int i=0;i<arr.length;i++) {
      min = Math.min(min, arr[i]);
      max = Math.max(max, arr[i]);
    }
    int[] store = new int[max - min + 1];
    for(int j=0;j<arr.length;j++) {
      store[arr[j] - min]++;
    }
    int index = 0;
    for(int k=0;k<store.length;k++) {
      while (store[k]-- > 0) {
        arr[index++] = k + min;
      }
    }
    return arr;
  }
}