package com.demo.java.design.pattern.abstractfactory;

public class JapanFactory implements MediaFactory {
  @Override
  public Film getFilm() {
    return new JapanFilm();
  }

  @Override
  public Music getMusic() {
    return new JapanMusic();
  }
}
