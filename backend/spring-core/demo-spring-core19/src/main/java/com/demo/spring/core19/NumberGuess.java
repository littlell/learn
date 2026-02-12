package com.demo.spring.core19;

public class NumberGuess {
  private double randomNumber;

  public void setRandomNumber(double randomNumber) {
    this.randomNumber = randomNumber;
  }

  @Override
  public String toString() {
    return "NumberGuess{" +
        "randomNumber=" + randomNumber +
        '}';
  }
}
