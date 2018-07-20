package com.lwb.learn.designpatterns.factory;

public class CarFactory1 extends AbstractFactory1 {
    @Override
    public Material createMateril() {
        return new Aluminum();
    }

    @Override
    public Product createProduct() {
        return new Car();
    }
}
