package com.demo.design.pattern.factormethod;

public class XiaoMiMobileFactory implements MobileFactory {
  @Override
  public Mobile create() {
    return new XiaoMiMobile();
  }
}
