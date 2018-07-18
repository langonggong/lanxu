package com.lanxu.study.hystrix;

import com.netflix.hystrix.HystrixCollapser;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixRequestLog;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import org.apache.ibatis.executor.BatchResult;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年06月17 17:30
 **/
public class CollapserCommand extends HystrixCollapser<List<String>, String, Integer> {

  private Integer key;

  public CollapserCommand(Integer key) {
    this.key = key;
  }

  @Override
  public Integer getRequestArgument() {
    return this.key;
  }

  @Override
  protected HystrixCommand<List<String>> createCommand(Collection<CollapsedRequest<String,
      Integer>> requests) {
    return new BatchCommand(requests);
  }

  @Override
  protected void mapResponseToRequests(
      List<String> batchResponse, Collection<CollapsedRequest<String, Integer>> requests) {
    AtomicInteger count = new AtomicInteger(0);
    requests.forEach(item -> item.setResponse(batchResponse.get(count.getAndIncrement())));
  }

  public static void main(String[] args) throws Exception{
    HystrixRequestContext context = HystrixRequestContext.initializeContext();

    Future<String> future1 = new CollapserCommand(1).queue();
    Future<String> future2 = new CollapserCommand(2).queue();
    Future<String> future3 = new CollapserCommand(3).queue();
    Future<String> future4 = new CollapserCommand(4).queue();
    future1.get();
    future2.get();
    future3.get();
    future4.get();

    System.out.println(HystrixRequestLog.getCurrentRequest().getExecutedCommands().size());
    context.shutdown();
  }
}