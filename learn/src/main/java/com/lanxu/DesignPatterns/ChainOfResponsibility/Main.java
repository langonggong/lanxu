package com.lanxu.DesignPatterns.ChainOfResponsibility;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年10月13 11:14
 **/

public class Main {

  public static void main(String[] args) {

    Request request = new Request.Builder().setName("张三").setDays(5)
        .setReason("事假").build();
    ChainOfResponsibilityClient client = new ChainOfResponsibilityClient();
    Result result = client.execute(request);

    System.out.println("结果：" + result.toString());
  }
}
