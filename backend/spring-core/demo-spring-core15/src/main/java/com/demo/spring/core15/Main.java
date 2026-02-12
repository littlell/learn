package com.demo.spring.core15;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    HelloService helloService = context.getBean("helloService", HelloService.class);

    System.out.println(helloService);
  }
}
