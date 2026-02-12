package com.demo.spring.core16;

import com.demo.spring.core16.repository.HelloRepository;
import com.demo.spring.core16.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class ServiceConfig {
  @Bean
  @Autowired
  public HelloService helloService(HelloRepository helloRepository) {
    return new HelloService(helloRepository);
  }
}
