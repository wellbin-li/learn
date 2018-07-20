package com.lwb.learn.designpatterns.factory;

public class BoatFactory extends AbstractFactory {
    @Override
    public Boat create() {
        return new Boat();
    }
}
