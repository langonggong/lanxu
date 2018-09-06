package com.lanxu.algorithm;

/**
 * 堆排序
 *
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年09月04 23:22
 **/
public class HeapSort {

  public int[] heapSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return arr;
    }
    //构建大根堆，使整棵树满足:父>子
    for (int i = arr.length / 2; i >= 0; i--) {
      //每次调整，都要保证将后面所有的都调整一遍
      headAdjust(arr, i, arr.length);
    }
    //将堆顶（最大值）替换到第j个点，然后将前面j-1个点调整为大根堆，
    //对前j-1个点重复此过程
    for(int j=arr.length-1;j>=0;j--) {
      swap(arr, 0, j);
      headAdjust(arr, 0, j);
    }
    return arr;
  }

  //保证[index,length)单条支线上的点满足:父节点大于子节点
  private void headAdjust(int[] arr, int index,int length) {
    while (index < length) {
      int left = 2 * index + 1;
      int right = 2 * index + 2;
      int max = index;
      if (left < length && arr[left] > arr[index]) {
        max = left;
      }
      if (right < length && arr[right] > arr[max]) {
        max = right;
      }
      if (index == max) {
        break;
      }
      swap(arr, index, max);
      index = max;
    }
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