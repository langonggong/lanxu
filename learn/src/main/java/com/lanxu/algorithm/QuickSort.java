package com.lanxu.algorithm;

/**
 * 快速排序
 *
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年09月03 21:41
 **/
public class QuickSort {

  public int[] quickSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return arr;
    }
    process(arr, 0, arr.length - 1);
    return arr;
  }

  public static void process(int[] arr, int left, int right) {
    if (left >= right) {
      return;
    }
    int random = left + (int) Math.random() * (right - left + 1);
    swap(arr, random, right);
    int partition = partition(arr, left, right);
    process(arr, left, partition - 1);
    process(arr, partition + 1, right);
  }

  /**
   * 将小于或等于right的元素替换到左边，大于right的元素保持不动
   * pivot加一递增，指向最近一个被替换到左边的位置
   * 当数组遍历完，right处的元素被替换到pivot所指的位置
   * pivot左边的值全部小于或等于该值，右边的值全部大于该值
   **/
  public static int partition(int[] arr, int left, int right) {
    int partition = left - 1;
    int index = left;
    while (index <= right) {
      if (arr[index] <= arr[right]) {
        swap(arr, ++partition, index);
      }
      index++;
    }
    return partition;
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