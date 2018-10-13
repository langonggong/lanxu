package com.lanxu.DesignPatterns.ChainOfResponsibility;

/**
 * Created by lanxu on 2018/10/13.
 *
 * 接口描述：处理请求
 */
public interface Ratify {
  // 处理请求
  public Result deal(Chain chain);

}
