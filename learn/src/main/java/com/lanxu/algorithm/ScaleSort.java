package com.lanxu.algorithm;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年09月07 00:30
 **/
public class ScaleSort {
  public int[] sortElement(int[] arr, int k) {
    if (arr == null || arr.length < 2) {
      return arr;
    }
    //构建长度为k的小根堆，此过程也可以在heap数组中进行
    for (int i = k / 2; i >= 0; i--) {
      headAdjust(arr, i, k);
    }
    //将调整好的最小根堆赋值给heap数组
    int[] heap = new int[k];
    for (int i = 0; i < k; i++) {
      heap[i] = arr[i];
    }
    //每从最小跟堆中弹出堆顶给数组，就从数组中弹出一个元素给堆，再次调整为最小跟堆
    for (int i = k; i < arr.length; i++) {
      arr[i - k] = heap[0];
      heap[0] = arr[i];
      headAdjust(heap, 0, k);
    }
    //最小根堆不能保证左右节点之间的大小顺序，所以不能直接将heap完整复制给arr
    for (int i = arr.length - k; i < arr.length; i++) {
      arr[i] = heap[0];
      //由于堆中没有新的元素加入，只能每次将堆顶放到后面，对前面一部分进行堆调整
      swap(heap, 0, arr.length - i - 1);
      headAdjust(heap, 0, arr.length - i - 1);
    }
    return arr;
  }

  //堆调整，保证[index,length)这条支线满足最小根堆
  private void headAdjust(int[] arr, int index, int length) {
    int minIndex, left, right;
    while (index < length) {
      minIndex = index;
      left = 2 * index + 1;
      right = 2 * index + 2;
      if (left < length && arr[left] < arr[minIndex]) {
        minIndex = left;
      }
      if (right < length && arr[right] < arr[minIndex]) {
        minIndex = right;
      }
      //临界条件，表示无需再调整
      if (index == minIndex) {
        break;
      }
      swap(arr, index, minIndex);
      index = minIndex;
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