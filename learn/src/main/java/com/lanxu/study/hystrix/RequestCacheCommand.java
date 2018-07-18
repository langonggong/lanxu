package com.lanxu.study.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import org.junit.Assert;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年06月17 16:43
 **/
public class RequestCacheCommand extends HystrixCommand<String> {
  private int id;

  public RequestCacheCommand(int id) {
    super(HystrixCommandGroupKey.Factory.asKey("RequestCacheCommand"));
    this.id = id;
  }

  @Override
  protected String run() throws Exception {
    return null;
  }

  @Override
  protected String getCacheKey() {
    return String.valueOf(id);
  }

  public static void main(String[] args) {
    HystrixRequestContext context = HystrixRequestContext.initializeContext();
    RequestCacheCommand command1 = new RequestCacheCommand(2);
    RequestCacheCommand command2 = new RequestCacheCommand(2);
    command1.execute();
    command2.execute();

    context.shutdown();

    Assert.assertTrue(command2.isResponseFromCache());

    context = HystrixRequestContext.initializeContext();
    RequestCacheCommand command3 = new RequestCacheCommand(2);
    command3.execute();
    Assert.assertFalse(command3.isResponseFromCache());

    context.shutdown();
  }
}