package com.lanxu.study.jvm.learn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年07月31 00:00
 **/
public class JConsoleMemoryTest {

  static class OOMObject {
    public byte[] placeHolder = new byte[64 * 1024];
  }

  public static void fillHeap(int num) throws Exception {
    List<OOMObject> list = new ArrayList<>();
    for (int i = 0; i < num; i++) {
      Thread.sleep(50);
      list.add(new OOMObject());
    }
    System.gc();
  }

  public static void main(String[] args) throws Exception {
    fillHeap(1000);
  }
}