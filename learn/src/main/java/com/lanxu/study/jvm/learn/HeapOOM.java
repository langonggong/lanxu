package com.lanxu.study.jvm.learn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年07月19 00:21
 **/
public class HeapOOM {

  public static void main(String[] args) {
    List<Object> list = new ArrayList<>();

    while (true) {
      list.add(new Object());
    }
  }
}