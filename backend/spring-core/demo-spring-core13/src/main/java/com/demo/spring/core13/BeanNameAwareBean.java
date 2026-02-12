package com.demo.spring.core13;

import org.springframework.beans.factory.BeanNameAware;

public class BeanNameAwareBean implements BeanNameAware {
  private String beanName;

  public void setBeanName(String s) {
    this.beanName = s;
  }

  public String getBeanName() {
    return beanName;
  }
}
