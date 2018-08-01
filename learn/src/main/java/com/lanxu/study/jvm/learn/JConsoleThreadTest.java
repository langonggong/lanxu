package com.lanxu.study.jvm.learn;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年07月31 23:42
 **/
public class JConsoleThreadTest {

  public static void createBusyThread() {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {

        }
      }
    }, "testBusyThread");
    thread.start();
  }

  public static void createLockThread(final Object lock) {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (lock) {
          try {
            lock.wait();
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }
    }, "testLockThread");
    thread.start();
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.readLine();
    createBusyThread();
    br.readLine();
    createLockThread(new Object());
  }
}