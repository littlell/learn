package com.demo.jvm.classloader.passive;

public class SubClass extends SuperClass{
  static {
    System.out.println("SubClass init!");
  }
}
