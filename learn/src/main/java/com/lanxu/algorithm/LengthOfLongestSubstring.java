package com.lanxu.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 无重复字符的最长子串
 *
 * @author lanxu
 * @url https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 * @email xu.lan@renren-inc.com
 * @create 2018年08月25 23:27
 **/
public class LengthOfLongestSubstring {

  public static int lengthOfLongestSubstring2(String s) {
    HashSet<Character> set = new HashSet<>();
    int start = 0, end = 0, result = 0;
    while (start < s.length() && end < s.length()) {
      if (set.contains(s.charAt(end))) {
        set.remove(s.charAt(start++));
      } else {
        set.add(s.charAt(end++));
        result = Math.max(result, end - start);
      }

    }
    return result;
  }

  public static void main(String[] args) {
    String str = "abcabcbb";
    System.out.println(lengthOfLongestSubstring2(str));
  }

}