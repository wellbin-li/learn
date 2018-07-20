package com.lwb.learn.designpatterns.proxy;

public class BuyHouseImpl implements BuyHouse {
    @Override
    public void buy() {
        System.out.println("我要买房");
    }
}
