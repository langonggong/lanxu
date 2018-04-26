package com.lanxu.study.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年04月26 22:30
 **/
public class CancellingExecutor extends ThreadPoolExecutor {
  public CancellingExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit
      unit, BlockingQueue<Runnable> workQueue) {
    super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
  }
}