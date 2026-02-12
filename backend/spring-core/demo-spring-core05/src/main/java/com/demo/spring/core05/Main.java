package com.demo.spring.core05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    HelloService helloService = context.getBean("helloService", HelloService.class);
    System.out.println(helloService);

    UserBean user01Bean = context.getBean("user01Bean", UserBean.class);
    System.out.println(user01Bean);

    UserBean user02Bean = context.getBean("user02Bean", UserBean.class);
    System.out.println(user02Bean);
  }
}
