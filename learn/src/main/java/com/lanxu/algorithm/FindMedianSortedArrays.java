package com.lanxu.algorithm;

/**
 * 两个排序数组的中位数
 *
 * @author lanxu
 * @url https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
 * @email xu.lan@renren-inc.com
 * @create 2018年08月26 11:10
 **/
public class FindMedianSortedArrays {

  public static double solution(int[] A, int[] B) {
    int m = A.length;
    int n = B.length;
    if (m > n) { // to ensure m<=n
      int[] temp = A; A = B; B = temp;
      int tmp = m; m = n; n = tmp;
    }
    int iMin = 0, iMax = m;
    int halfLen = (m + n + 1) / 2;
//    int halfLen = (m + n) % 2 == 0 ? ((m + n) / 2 + 1) : (m + n + 1) / 2;
    while (iMin <= iMax) {
      int i = (iMin + iMax) / 2;
      int j = halfLen - i;
      if (i < iMax && B[j-1] > A[i]){
        iMin = i + 1; // i is too small
      }
      else if (i > iMin && A[i-1] > B[j]) {
        iMax = i - 1; // i is too big
      }
      else { // i is perfect
        int maxLeft = 0;
        if (i == 0) { maxLeft = B[j-1]; }
        else if (j == 0) { maxLeft = A[i-1]; }
        else { maxLeft = Math.max(A[i-1], B[j-1]); }
        if ( (m + n) % 2 == 1 ) { return maxLeft; }

        int minRight = 0;
        if (i == m) { minRight = B[j]; }
        else if (j == n) { minRight = A[i]; }
        else { minRight = Math.min(B[j], A[i]); }

        return (maxLeft + minRight) / 2.0;
      }
    }
    return 0.0;
  }

  public static void main(String[] args) {
    int[] num1 = {1};
    int[] num2 = {3, 4};
    System.out.println(solution(num1,num2));
  }
}