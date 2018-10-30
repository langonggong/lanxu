package com.lanxu.algorithm;

import com.lanxu.study.effectiveJava.Chapter5.Item28.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年10月19 15:51
 **/
public class TreeToSequence {

  public int[][] convert(TreeNode root) {
    if (root == null) {
      return null;
    }
    int[][] res = new int[3][];
    res[0] = pre(root);
    res[1] = mid(root);
    res[2] = after(root);

    return res;
  }

  private int[] pre(TreeNode node) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur;
    List<Integer> list = new ArrayList<>();
    stack.push(node);

    while (!stack.isEmpty()) {
      cur = stack.pop();
      list.add(cur.val);
      if (cur.right != null) {
        stack.push(cur.right);
      }
      if (cur.left != null) {
        stack.push(cur.left);
      }
    }

    return list2arr(list);
  }

  public int[] mid(TreeNode node) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = node;
    List<Integer> list = new ArrayList<>();
    stack.push(node);

    while (!stack.isEmpty()) {
      while (cur != null && cur.left != null) {
        stack.push(cur.left);
        cur = cur.left;
      }
      cur = stack.pop();
      list.add(cur.val);
      if (cur.right != null) {
        stack.push(cur.right);
      }
      cur = cur.right;
    }

    return list2arr(list);
  }

  private int[] after(TreeNode node) {
    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();

    TreeNode cur;
    stack1.push(node);

    while (!stack1.isEmpty()) {
      cur = stack1.pop();
      stack2.push(cur);

      if (cur.left != null) {
        stack1.push(cur.left);
      }
      if (cur.right != null) {
        stack1.push(cur.right);
      }
    }

    List<Integer> list = new ArrayList<>();
    while (!stack2.isEmpty()) {
      list.add(stack2.pop().val);
    }

    return list2arr(list);
  }

  private int[] list2arr(List<Integer> list) {
    int[] arr = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      arr[i] = list.get(i);
    }
    return arr;
  }

  public static void main(String[] args) {
    TreeToSequence treeToSequence = new TreeToSequence();

    TreeNode t1 = new TreeNode(1);
    TreeNode t2 = new TreeNode(2);
    TreeNode t3 = new TreeNode(3);
    TreeNode t4 = new TreeNode(4);
    TreeNode t5 = new TreeNode(5);
    TreeNode t6 = new TreeNode(6);
    TreeNode t7 = new TreeNode(7);
    TreeNode t8 = new TreeNode(8);
    TreeNode t9= new TreeNode(9);
    TreeNode t10 = new TreeNode(10);

    t1.left = t2;
    t1.right = t3;
    t2.left = t4;
    t2.right = t5;
    t3.left = t6;
    t3.right = t7;
    t4.left = t8;
    t4.right = t9;
    t5.left = t10;

    int[] mid = treeToSequence.mid(t1);
    for (int i : mid) {
      System.out.println(i);
    }

  }
}