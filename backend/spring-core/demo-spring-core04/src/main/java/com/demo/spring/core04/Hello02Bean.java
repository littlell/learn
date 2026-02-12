package com.demo.spring.core04;

public class Hello02Bean {
    private static Hello02Bean helloBean = new Hello02Bean();

    public static Hello02Bean createInstance(){
        return helloBean;
    }
}
