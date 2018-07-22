package com.lanxu.study.jvm.learn;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年07月22 15:25
 **/
public class TestAllocation {
  private static final int _1M = 1024 * 1024;

  public static void main(String[] args) {
    byte[] allocation1, allocation2, allocation3, allocation4;
    allocation1 = new byte[2 * _1M];
    allocation2 = new byte[2 * _1M];
    allocation3 = new byte[2 * _1M];
    allocation4 = new byte[4 * _1M];
  }
}