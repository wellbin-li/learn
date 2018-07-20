package com.lwb.learn.designpatterns.factory;

public class PlaneFactory1 extends AbstractFactory1 {
    @Override
    public Material createMateril() {
        return new Alloy();
    }

    @Override
    public Product createProduct() {
        return new Plane();
    }
}
