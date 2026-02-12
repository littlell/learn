package com.demo.spring.core12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Main {

  public static void main(String[] args) throws SQLException {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    System.out.println(context.getBean("hello1"));
    System.out.println(context.getBean("hello1"));
    System.out.println(context.getBean("hello2"));
    System.out.println(context.getBean("hello2"));
  }
}
