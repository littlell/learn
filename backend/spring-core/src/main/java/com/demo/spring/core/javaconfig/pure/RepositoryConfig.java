package com.demo.spring.core.javaconfig.pure;

import com.demo.spring.core.javaconfig.pure.repository.HelloRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class RepositoryConfig {
  @Bean
  public HelloRepository helloRepository() {
    return new HelloRepository();
  }
}
