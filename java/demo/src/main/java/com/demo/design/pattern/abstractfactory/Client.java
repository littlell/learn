package com.demo.design.pattern.abstractfactory;

public class Client {
  public static void main(String[] args) {
    MediaFactory factory = new ChinaFactory();

    Music music = factory.getMusic();
    Film film = factory.getFilm();

    music.play();
    film.play();
  }
}
