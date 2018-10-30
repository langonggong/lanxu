package com.lanxu.algorithm;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年10月19 20:21
 **/
public class CheckCompletion {

  public boolean chk(TreeNode root) {
    TreeNode[] arr = new TreeNode[501];
    int head = 0, tail = 0;
    TreeNode cur;
    arr[tail++] = root;

    while (head != tail) {
      cur = arr[head++];
      if (cur.left != null) {
        arr[tail++] = cur.left;
      }
      if (cur.right != null) {
        arr[tail++] = cur.right;
      }
    }

    boolean isTail = false;
    for(int i=0;i<tail;i++) {
      cur = arr[i];
      if (cur.left == null || cur.right == null) {
        if (cur.left == null && cur.right != null) {
          return false;
        }
        if (!isTail) {
          isTail = true;
        } else if (cur.left != null || cur.right != null) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    TreeNode t1 = new TreeNode(1);
    TreeNode t2 = new TreeNode(2);
    TreeNode t3 = new TreeNode(3);
    TreeNode t4 = new TreeNode(4);
    TreeNode t5 = new TreeNode(5);
    TreeNode t6 = new TreeNode(6);
    TreeNode t7 = new TreeNode(7);
    TreeNode t8 = new TreeNode(8);
    TreeNode t9 = new TreeNode(9);
    TreeNode t10 = new TreeNode(10);
    TreeNode t11 = new TreeNode(11);
    TreeNode t12 = new TreeNode(12);
    TreeNode t13 = new TreeNode(13);
    TreeNode t14 = new TreeNode(14);

    t1.left = t2;
    t1.right = t3;
    t2.left = t4;
    t2.right = t5;
    t3.right = t6;
    t3.right = t7;
    t4.left = t8;
    t4.right = t9;
    t5.left = t10;
    t5.right = t11;
    t6.left = t12;
    t6.right = t13;
    t7.left = t14;

    CheckCompletion checkCompletion = new CheckCompletion();
    boolean chk = checkCompletion.chk(t1);

    System.out.println(chk);

  }
}