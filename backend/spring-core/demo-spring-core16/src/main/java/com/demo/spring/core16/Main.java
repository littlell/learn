package com.demo.spring.core16;

import com.demo.spring.core16.bean.HelloBean;
import com.demo.spring.core16.service.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

    ctx.scan("com.demo.spring.core16");

    HelloBean helloBean = ctx.getBean(HelloBean.class);
    System.out.println(helloBean);

    helloBean = ctx.getBean(HelloBean.class);
    System.out.println(helloBean);

    helloBean = (HelloBean) ctx.getBean("hello");
    System.out.println(helloBean);

    helloBean = (HelloBean) ctx.getBean("helloNew");
    System.out.println(helloBean);

    HelloService helloService = ctx.getBean(HelloService.class);
    System.out.println(helloService);
  }
}
