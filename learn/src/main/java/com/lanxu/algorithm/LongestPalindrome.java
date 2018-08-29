package com.lanxu.algorithm;

/**
 * 最长回文子串
 *
 * @author lanxu
 * @url https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 * @email xu.lan@renren-inc.com
 * @create 2018年08月28 22:20
 **/
public class LongestPalindrome {

  private int globalStart = 0, globalEnd = 0;

  public String longestPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }
    for(int i=0;i<s.length();i++) {
      update(s, i, i);
      update(s, i, i + 1);
    }
    return s.substring(globalStart, globalEnd + 1);
  }

  private void update(String s, int start, int end) {
    boolean flag = false;
    while (start >= 0 && end < s.length()  && s.charAt(start) == s.charAt(end)) {
      start--;
      end++;
      flag = true;
    }
    if (!flag) {
      return;
    }
    start++;
    end--;
    if (end - start > globalEnd - globalStart) {
      globalStart = start;
      globalEnd = end;
    }
  }

  public static void main(String[] args) {
    LongestPalindrome l = new LongestPalindrome();
    String str = "a";
    System.out.println(l.longestPalindrome(str));
  }
}