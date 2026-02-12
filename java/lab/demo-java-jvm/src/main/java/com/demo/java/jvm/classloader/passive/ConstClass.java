package com.demo.java.jvm.classloader.passive;

public class ConstClass {

  static {
    System.out.println("ConstClass init!");
  }

  public static final String HELLOWORLD = "hello world";
}
