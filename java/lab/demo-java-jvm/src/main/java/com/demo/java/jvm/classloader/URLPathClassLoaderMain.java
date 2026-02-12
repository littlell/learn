package com.demo.java.jvm.classloader;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class URLPathClassLoaderMain {
  public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    File classFileDir = new File("E:/demo-java/demo-java-classloader/target/classes");
    URL classFileDirUrl = classFileDir.toURI().toURL();

    URL[] urls = new URL[]{classFileDirUrl};

    URLPathClassLoader urlPathClassLoader = new URLPathClassLoader(urls);

    Class<?> aClass = urlPathClassLoader.loadClass("com.demo.java.classloader.Demo");

    System.out.println("classLoader: " + aClass.getClassLoader());

    Object object = aClass.getDeclaredConstructor().newInstance();

    Method method = aClass.getMethod("print");

    method.invoke(object);
  }
}
