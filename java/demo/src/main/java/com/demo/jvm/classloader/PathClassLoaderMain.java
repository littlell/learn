package com.demo.jvm.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PathClassLoaderMain extends ClassLoader {

  public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
    PathClassLoader pathClassLoader = new PathClassLoader("E:/demo-java/demo-java-classloader/target/classes/");

    Class<?> aClass = pathClassLoader.loadClass("com.demo.classloader.Demo");

    System.out.println("classLoader: " + aClass.getClassLoader());

    Object object = aClass.getDeclaredConstructor().newInstance();

    Method method = aClass.getMethod("print");

    method.invoke(object);
  }
}
