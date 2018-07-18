package com.lanxu.study.hystrix;

import rx.Observable;
import rx.Observer;
import rx.functions.Action1;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年06月17 15:01
 **/
public class ObservableTest {
  public static void main(String[] args) {
    HelloWorldCommand command = new HelloWorldCommand("test");
    Observable<String> observe = command.observe();
    observe.subscribe(new Action1<String>() {
      @Override
      public void call(String s) {
        System.out.println("call " + s);
      }
    });

    observe.subscribe(new Observer<String>() {
      @Override
      public void onCompleted() {
        System.out.println(" complete");
      }

      @Override
      public void onError(Throwable throwable) {
        System.out.println("error");
      }

      @Override
      public void onNext(String s) {
        System.out.println("next");
      }
    });

//    command.execute();
  }
}