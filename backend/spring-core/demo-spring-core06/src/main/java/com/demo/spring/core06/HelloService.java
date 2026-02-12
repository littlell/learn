package com.demo.spring.core06;

public class HelloService {
    private HelloDao helloDao;

    public HelloDao getHelloDao() {
        return helloDao;
    }

    public void setHelloDao(HelloDao helloDao) {
        this.helloDao = helloDao;
    }
}
