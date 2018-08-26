package com.lanxu.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * @url https://leetcode-cn.com/problems/two-sum/solution/
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年08月25 15:24
 **/
public class TwoSum {

  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      int last = target - num;
      if (map.containsKey(last)) {
        return new int[]{i, map.get(last)};
      } else {
        map.put(num, i);
      }

    }
    return null;
  }

  public static void main(String[] args) {
    int[] nums = {2,7,11,15};
    int target = 9;
    int[] result = twoSum(nums, target);
    for (int i : result) {
      System.out.println(i);
    }
  }
}