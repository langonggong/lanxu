package com.lanxu.study.jvm.learn;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年07月25 17:04
 **/
public class TestClass3 {

  private static final int _1MB = 1024 * 1024;

  public static void testTenuringThreshold() {
    byte[] allocation1, allocation2, allocation3;
    allocation1 = new byte[_1MB / 4];
    allocation2 = new byte[4 * _1MB];
    allocation3 = new byte[4 * _1MB];
    allocation3 = null;
    allocation3 = new byte[4 * _1MB];
  }

  public static void main(String[] agrs) {
    testTenuringThreshold();
  }
}