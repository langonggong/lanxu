package com.lanxu.study.jvm.learn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年08月01 22:54
 **/
public class JavaHeapTest {
  public final static int OUTOFMEMORY = 200000000;

  private String oom;

  private int length;

  StringBuffer tempOOM = new StringBuffer();

  public JavaHeapTest(int leng) {
    this.length = leng;

    int i = 0;
    while (i < leng) {
      i++;
      try {
        tempOOM.append("a");
      } catch (OutOfMemoryError e) {
        e.printStackTrace();
        break;
      }
    }
    this.oom = tempOOM.toString();

  }

  public String getOom() {
    return oom;
  }

  public int getLength() {
    return length;
  }

  public static void main(String[] args) throws Exception{
//    Thread.sleep(9000, 0);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.readLine();

    JavaHeapTest javaHeapTest = new JavaHeapTest(OUTOFMEMORY);
    System.out.println(javaHeapTest.getOom().length());

    br.readLine();
  }

}