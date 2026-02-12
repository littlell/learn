package com.demo.spring.core20;

public class DefaultFooService implements FooService {
  public String getFoo(String name, int age) {
    System.out.println("executing getFoo...");
    if (age < 0) {
      throw new RuntimeException("invalid");
    }
    return String.format("%s,%s", name, age);
  }
}
