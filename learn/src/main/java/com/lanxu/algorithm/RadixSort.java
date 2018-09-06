package com.lanxu.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 基数排序
 *
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年09月06 22:19
 **/
public class RadixSort {

  public int[] radixSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return arr;
    }
    int posNum = 0;
    for (int i : arr) {
      if (i >= 0) {
        posNum++;
      }
    }
    int[] posArr = new int[posNum];
    int[] negArr = new int[arr.length - posNum];
    int posIndex = 0, negIndex = 0, posMax = 0, negMax = 0;
    for (int i : arr) {
      if (i >= 0) {
        posArr[posIndex++] = i;
        posMax = Math.max(posMax, i);
      } else {
        int j = -i;
        negArr[negIndex++] = j;
        negMax = Math.max(j, negMax);
      }
    }
    radixSortForPositive(posArr, posMax);
    radixSortForPositive(negArr, negMax);
    int index = 0;
    for(int i=negArr.length-1;i>=0;i--) {
      arr[index++] = -negArr[i];
    }
    for(int i=0;i<posArr.length;i++) {
      arr[index++] = posArr[i];
    }
    return arr;
  }

  //针对正数的基数排序
  private static void radixSortForPositive(int[] arr, int max) {
    List<LinkedList<Integer>> temp1 = new ArrayList<>();
    List<LinkedList<Integer>> temp2 = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      temp1.add(new LinkedList<>());
      temp2.add(new LinkedList<>());
    }
    //按照个位数的大小将元素放入桶中
    for (int i : arr) {
      temp1.get(i % 10).add(i);
    }

    for (int base = 10; base <= max; base *= 10) {
      for (LinkedList<Integer> integers : temp1) {
        while (!integers.isEmpty()) {
          Integer integer = integers.pop();
          temp2.get((integer / base) % 10).add(integer);
        }
      }
      List<LinkedList<Integer>> temp;
      temp = temp1;
      temp1 = temp2;
      temp2 = temp;
    }
    int index = 0;
    for (LinkedList<Integer> integers : temp1) {
      for (Integer integer : integers) {
        arr[index++] = integer;
      }
    }
  }
}