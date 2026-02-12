package com.demo.basics.serialize.bean;

public class Dog extends Animal {

  /**
   * home wild
   */
  private String type;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "Dog{" +
        "type='" + type + '\'' +
        ", age=" + age +
        ", gender='" + gender + '\'' +
        '}';
  }
}
