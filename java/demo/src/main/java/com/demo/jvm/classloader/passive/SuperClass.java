package com.demo.jvm.classloader.passive;

public class SuperClass {
  static {
    System.out.println("Super class init!");
  }

  public static int value = 123;
}
