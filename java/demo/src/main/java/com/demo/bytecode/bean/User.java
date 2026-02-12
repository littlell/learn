package com.demo.bytecode.bean;

public class User extends RuntimeException {

  private String name;
  private int age;

  public void hi() {
    System.out.println("Hi");
  }
}
