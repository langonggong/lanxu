package com.lanxu.study.hystrix;

import com.netflix.hystrix.HystrixCollapser;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年06月17 17:34
 **/
public class BatchCommand extends HystrixCommand<List<String>>{

  private Collection<HystrixCollapser.CollapsedRequest<String, Integer>> requests;

  public BatchCommand(Collection<HystrixCollapser.CollapsedRequest<String, Integer>> requests ) {
    super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("batchGroup")).andCommandKey
        (HystrixCommandKey.Factory.asKey("GetValueForKey")));
    this.requests = requests;
  }

  @Override
  protected List<String> run() throws Exception {
    return requests.stream()
        .map(s -> "ValueForKey: " + s.getArgument())
        .collect(Collectors.toList());
  }
}