package com.lwb.learn.designpatterns.factory;

public class PlaneFactory extends AbstractFactory {
    @Override
    public Plane create() {
        return new Plane();
    }
}
