package com.lanxu.algorithm;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年09月12 23:13
 **/
public class Checker {

  public boolean checkDuplicate(int[] arr, int n) {
    if (arr == null || arr.length < 2) {
      return false;
    }
    //构建大根堆
    for (int i = arr.length / 2; i >= 0; i--) {
      headAdjust(arr, i, arr.length);
    }
    //排序
    for (int i = arr.length - 1; i >= 0; i--) {
      swap(arr, 0, i);
      headAdjust(arr, 0, i);
    }
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] == arr[i + 1]) {
        return true;
      }
    }
    return false;
  }

  private void headAdjust(int[] arr, int index, int length) {
    while (index < length) {
      int left = 2 * index + 1;
      int right = 2 * index + 2;
      int maxIndex = index;
      if (left < length && arr[left] > arr[maxIndex]) {
        maxIndex = left;
      }
      if (right < length && arr[right] > arr[maxIndex]) {
        maxIndex = right;
      }
      if (maxIndex == index) {
        break;
      }
      swap(arr, index, maxIndex);
      index = maxIndex;
    }
  }

  private void swap(int[] arr, int index1, int index2) {
    if (index1 == index2) {
      return;
    }

    int tmp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = tmp;
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 5, 6};
    Checker checker = new Checker();
    boolean checkDuplicate = checker.checkDuplicate(arr, 0);
    System.out.println(checkDuplicate);
  }
}