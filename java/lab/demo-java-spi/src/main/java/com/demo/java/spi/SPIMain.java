package com.demo.java.spi;

import java.util.ServiceLoader;

public class SPIMain {
  public static void main(String[] args) {
    ServiceLoader<IShout> shouts = ServiceLoader.load(IShout.class);
    shouts.findFirst().get().shout();

    /**
     for (IShout shout : shouts) {
     shout.shout();
     }
     **/
  }
}
