package com.demo.spring.core04;

public class Hello01Bean {
    private static Hello01Bean helloBean = new Hello01Bean();

    public static Hello01Bean createInstance(){
        return helloBean;
    }
}
