package com.lwb.learn.designpatterns.factory;

public class ProductFactory {

    public ProductFactory(){

    }

    public Product create(String type){
        switch (type){
            case "boat":
                return new Boat();
            case "car":
                return new Car();
            case "plane":
                return new Plane();
            default:
                return null;
        }
    }
}
