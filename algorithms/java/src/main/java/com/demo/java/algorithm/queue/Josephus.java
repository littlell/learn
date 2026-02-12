package com.demo.java.algorithm.queue;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class Josephus {
  public static void main(String[] args) {

    Queue<String> kids = new ArrayBlockingQueue<String>(4);
    kids.add("Joe");
    kids.add("Matt");
    kids.add("Ann");
    kids.add("Susan");

    String winner = josephus(kids);

    System.out.println("Winner is " + winner);
  }

  public static String josephus(Queue<String> queue) {

    for (int i = 0; i < queue.size() - 1; i++) {

      int rand = new Random().nextInt(50);

      for (int j = 0; j < rand; j++) {
        String s = queue.poll();
        queue.add(s);
      }

      queue.poll();
    }

    return queue.poll();
  }

}
