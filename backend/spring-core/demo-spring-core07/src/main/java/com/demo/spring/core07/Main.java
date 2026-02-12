package com.demo.spring.core07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Main {

  public static void main(String[] args) throws SQLException {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    ComplexBean complexBean = context.getBean("complexBean", ComplexBean.class);
    System.out.println(complexBean);
  }
}
