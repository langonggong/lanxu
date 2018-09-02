package com.lanxu.algorithm;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年09月02 17:05
 **/
public class KMP {

  private int[] getNextArr(char[] pattern) {
    if (pattern == null || pattern.length == 1) {
      return new int[]{-1};
    }
    int[] next = new int[pattern.length];
    next[0] = -1;
    next[1] = 0;
    int currentNext=0;
    int pos = 2;
    while (pos < pattern.length) {
      if (pattern[pos - 1] == pattern[currentNext]) {
        next[pos++] = ++currentNext;
      } else if (currentNext > 0) {
        currentNext = next[currentNext];
      } else {
        next[pos++] = 0;
      }
    }
    return next;
  }

  public int getIndexOf(String ori, String pattern) {
    if (ori.length() < pattern.length()) {
      return -1;
    }
    char[] oriArr = ori.toCharArray();
    char[] patternArr = pattern.toCharArray();

    int indexOfOri = 0;
    int indexOfPattern = 0;

    int[] next = getNextArr(patternArr);

    while (indexOfOri < oriArr.length && indexOfPattern < patternArr.length) {
      if (oriArr[indexOfOri] == patternArr[indexOfPattern]) {
        indexOfOri++;
        indexOfPattern++;
      } else if (next[indexOfPattern] >= 0) {
        indexOfPattern = next[indexOfPattern];
      } else {
        indexOfOri++;
      }
    }
    return indexOfPattern == patternArr.length ? indexOfOri - indexOfPattern : -1;
  }

}