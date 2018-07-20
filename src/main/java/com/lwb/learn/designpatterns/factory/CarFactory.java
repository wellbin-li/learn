package com.lwb.learn.designpatterns.factory;

public class CarFactory extends AbstractFactory {
    @Override
    public Car create() {
        return new Car();
    }
}
