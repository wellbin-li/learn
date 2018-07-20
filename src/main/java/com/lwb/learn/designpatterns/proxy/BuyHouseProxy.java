package com.lwb.learn.designpatterns.proxy;

public class BuyHouseProxy implements BuyHouse {

    private BuyHouse buyHouse;

    public BuyHouseProxy(BuyHouse buyHouse){
        this.buyHouse = buyHouse;
    }

    @Override
    public void buy() {
        System.out.println("买房前准备");
        buyHouse.buy();
        System.out.println("买房后装修");
    }
}
