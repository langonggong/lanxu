package com.lanxu.algorithm;

/**
 * @url https://www.nowcoder.com/study/vod/1/2/15
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年09月12 23:51
 **/
public class Merge {

  public int[] mergeAB(int[] A, int[] B, int n, int m) {
    while (m > 0) {
      if (n == 0) {
        A[m-1] = B[m-1];
        m--;
      } else {
        A[m + n - 1] = A[n - 1] > B[m - 1] ? A[--n] : B[--m];
      }
    }
    return A;
  }
}