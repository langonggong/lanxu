package com.lanxu.algorithm;

/**
 * 希尔排序
 *
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年09月05 22:48
 **/
public class ShellSort {

  public int[] shellSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return arr;
    }
    int length = arr.length ;
    //将数组2等分，4等分...知道一等分
    for (int gap = length >> 1; gap > 0; gap >>= 1) {
      //对生成的多个数组进行插入排序
      for (int start = gap; start < arr.length; start++) {
        //对单个数组进行插入排序
        for (int index = start; index >= gap; index -= gap) {
          if (arr[index - gap] > arr[index]) {
            swap(arr, index - gap, index);
          }
        }
      }
    }
    return arr;
  }
  public static void swap(int[] arr, int index1, int index2) {
    if (index1 == index2) {
      return;
    }
    int tmp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = tmp;
  }
}