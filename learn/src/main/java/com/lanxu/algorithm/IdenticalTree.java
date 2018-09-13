package com.lanxu.algorithm;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年09月13 23:02
 **/
public class IdenticalTree {

  public boolean chkIdentical(TreeNode A, TreeNode B) {
    String strA = getStr(A);
    String strB = getStr(B);
    return getIndexOf(strA, strB) > -1;
  }

  private String getStr(TreeNode treeNode) {
    if (treeNode == null) {
      return "#";
    }
    StringBuilder sb = new StringBuilder();
    sb.append(treeNode.val);
    sb.append(getStr(treeNode.left));
    sb.append(getStr(treeNode.right));
    return sb.toString();
  }

  public int getIndexOf(String ori, String pattern) {
    if (ori.length() < pattern.length()) {
      return -1;
    }
    char[] oriArr = ori.toCharArray();
    char[] patternArr = pattern.toCharArray();
    int[] next = getNext(patternArr);

    int oriIndex = 0;
    int patIndex = 0;
    while (oriIndex < oriArr.length && patIndex < patternArr.length) {
      if (oriArr[oriIndex] == patternArr[patIndex]) {
        oriIndex++;
        patIndex++;
      } else if (next[patIndex] >= 0) {
        patIndex = next[patIndex];
      } else {
        oriIndex++;
      }
    }
    return patIndex == patternArr.length ? oriIndex - patIndex : -1;
  }

  private int[] getNext(char[] arr) {
    if (arr == null || arr.length < 2) {
      return new int[]{-1};
    }
    int currentNext = 0, pos = 2;
    int[] next = new int[arr.length];
    next[0] = -1;
    next[1] = 0;
    while (pos < arr.length) {
      if (arr[pos - 1] == arr[currentNext]) {
        next[pos++] = ++currentNext;
      } else if (currentNext > 0) {
        currentNext = next[currentNext];
      } else {
        next[pos++] = 0;
      }
    }
    return next;
  }
}