package com.demo.spring.core23;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    UserClientService userService = (UserClientService) context.getBean("userClientService");

//    userService.insert();

    System.out.println(userService.selectAgeByName("foo"));
  }
}
