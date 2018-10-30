package com.lanxu.algorithm;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年10月19 20:00
 **/
public class CheckBalance {

  public boolean check(TreeNode root) {
    return chk(root) != -1;
  }

  public int chk(TreeNode treeNode) {
    if (treeNode == null) {
      return 0;
    }

    int left = chk(treeNode.left);
    int right = chk(treeNode.right);

    if (left < 0 || right < 0 || Math.abs(left - right) > 1) {
      return -1;
    }
    return Math.max(left, right) + 1;
  }
}