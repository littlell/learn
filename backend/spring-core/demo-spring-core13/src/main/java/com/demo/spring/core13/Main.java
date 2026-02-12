package com.demo.spring.core13;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Main {

  public static void main(String[] args) throws SQLException {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    BeanNameAwareBean beanNameAwareBean = context.getBean(BeanNameAwareBean.class);
    System.out.println(beanNameAwareBean.getBeanName());

    context.registerShutdownHook();
  }
}
