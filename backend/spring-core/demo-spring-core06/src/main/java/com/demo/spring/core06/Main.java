package com.demo.spring.core06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        HelloService helloService = (HelloService) context.getBean("helloService");
        System.out.println(helloService);
        System.out.println(helloService.getHelloDao());

        UserBean userBean = (UserBean) context.getBean("userBean");
        System.out.println(userBean);
    }
}
