package com.lanxu.DesignPatterns.ChainOfResponsibility;

/**
 * 接口描述：对request和Result封装，用来转发
 */
public interface Chain {
  // 获取当前request
  Request request();

  // 转发request
  Result proceed(Request request);
}