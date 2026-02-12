package com.demo.spring.core16;

import com.demo.spring.core16.bean.HelloBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
@Import({RepositoryConfig.class, ServiceConfig.class})
public class AppConfig {

  @Bean(name = {"hello", "helloNew"})
  @Scope("prototype")
  public HelloBean helloBean() {
    return new HelloBean();
  }
}
