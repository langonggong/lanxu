package com.lanxu.study.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import java.util.concurrent.TimeUnit;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年06月17 16:25
 **/
public class FallBackCommand extends HystrixCommand<String> {

  String name;

  public FallBackCommand(String name) {
    super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("fallBackGroup"))
        .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
            .withExecutionIsolationThreadTimeoutInMilliseconds(500)));
    this.name = name;
  }

  @Override
  protected String getFallback() {
    return "execute fallback";
  }

  @Override
  protected String run() throws Exception {
    TimeUnit.MILLISECONDS.sleep(1000);
    return Thread.currentThread().getName();
  }

  public static void main(String[] args) {
    FallBackCommand fallBackCommand = new FallBackCommand("test fallback");
    System.out.println(fallBackCommand.execute());
  }

}