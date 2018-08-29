package com.lanxu.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年08月28 23:36
 **/
public class TreePrinter {
  public static int[][] printTree(TreeNode root) {

    List<TreeNode> before = new ArrayList<>();
    before.add(root);
    List<TreeNode> after;

    List<List<Integer>> result = new ArrayList<>();

    while (before.size() > 0) {
      List<Integer> list = new ArrayList<>();
      after = new ArrayList<>();
      for (TreeNode node : before) {
        if (node.left != null)
          after.add(node.left);
        if (node.right != null) {
          after.add(node.right);
        }
        list.add(node.val);
      }
      result.add(list);
      before = after;
    }

    int[][] arr = new int[result.size()][];
    for (int j = 0; j < result.size(); j++) {
      List<Integer> list = result.get(j);
      int[] tmp = new int[list.size()];
      for (int i = 0; i < list.size(); i++) {
        tmp[i] = list.get(i);
      }
      arr[j] = tmp;
    }
    return arr;
  }

  public static void main(String[] args) {
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(5);

    n1.left = n2;
    n1.right = n3;
    n3.left = n4;
    n3.right = n5;

    int[][] arr = printTree(n1);

    for (int[] ints : arr) {
      for (int anInt : ints) {
        System.out.print(anInt + "\t");
      }
      System.out.println();
    }
  }
}