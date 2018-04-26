package com.lanxu.study.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年04月26 22:26
 **/
public interface CancellbaleTask<T> extends Callable<T> {
  void cancel();

  RunnableFuture<T> newTask();
}