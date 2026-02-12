package com.demo.spring.core03;

public class HelloBean {
  private static HelloBean helloBean = new HelloBean();

  public static HelloBean createInstance() {
    return helloBean;
  }
}
