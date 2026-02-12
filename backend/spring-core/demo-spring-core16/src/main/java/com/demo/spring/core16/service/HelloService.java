package com.demo.spring.core16.service;

import com.demo.spring.core16.repository.HelloRepository;

public class HelloService {
  private HelloRepository helloRepository;

  public HelloService(HelloRepository helloRepository) {
    this.helloRepository = helloRepository;
  }

  @Override
  public String toString() {
    return "HelloService{" +
        "helloRepository=" + helloRepository +
        '}';
  }
}
