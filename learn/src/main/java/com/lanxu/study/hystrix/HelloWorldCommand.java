package com.lanxu.study.hystrix;

import com.netflix.hystrix.HystrixCircuitBreaker;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.concurrent.TimeUnit;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年06月17 12:51
 **/
public class HelloWorldCommand extends HystrixCommand<String> {

  private String name;

  public HelloWorldCommand(String name) {
    super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
    this.name = name;
  }

  @Override
  protected String run() throws Exception {
    return "Hello " + name + " thread:" + Thread.currentThread().getName();
  }

  public static void main(String[] args) throws Exception{
    HelloWorldCommand sync = new HelloWorldCommand("Synchronous-hystrix");
    System.out.println(sync.execute());

    HelloWorldCommand async = new HelloWorldCommand("Asynchronous-hystrix");
    System.out.println(async.queue().get(200, TimeUnit.MILLISECONDS));

    System.out.println(Thread.currentThread().getName());

  }

}