package com.lanxu.algorithm;

import com.lanxu.util.JacksonUtils;

/**
 * @author lanxu
 * @url https://www.nowcoder.com/study/vod/1/2/17
 * @email xu.lan@renren-inc.com
 * @create 2018年09月13 00:04
 **/
public class ThreeColor {

  public int[] sortThreeColor(int[] arr, int n) {
    if (arr == null || arr.length < 2) {
      return arr;
    }
    int index = 0, left = -1, right = arr.length;
    while (index < right) {
      switch (arr[index]) {
        case 0:
          swap(arr, ++left, index++);
          break;
        case 1:
          index++;
          break;
        case 2:
          swap(arr, --right, index);
          break;
        default:
          break;
      }
    }
    return arr;
  }

  private void swap(int[] arr, int index1, int index2) {
    if (index1 == index2) {
      return;
    }

    int tmp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = tmp;
  }

  public static void main(String[] args) throws Exception {
    int[] arr = {1, 2, 0, 2};
    ThreeColor threeColor = new ThreeColor();
    threeColor.sortThreeColor(arr, 0);
    System.out.println(JacksonUtils.toJson(arr));
  }
}