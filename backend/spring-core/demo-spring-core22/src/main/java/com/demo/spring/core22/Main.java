package com.demo.spring.core22;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    UserClientService userService = context.getBean("userClientService", UserClientService.class);

    userService.propagationRequire();

//    userService.propagationRequireNew();
//
//    userService.propagationSupport();
//
//    userService.propagationMandatory();
//
//    userService.propagationNotSupported();
//
//    userService.propagationNotNever();
  }
}
