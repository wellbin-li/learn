package com.lwb.learn.designpatterns.factory;

public class BoatFactory1 extends AbstractFactory1 {

    @Override
    public Material createMateril() {
        return new Steel();
    }

    @Override
    public Product createProduct() {
        return new Boat();
    }
}
