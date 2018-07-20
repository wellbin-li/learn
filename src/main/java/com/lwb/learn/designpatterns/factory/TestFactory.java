package com.lwb.learn.designpatterns.factory;

/**
 * 工厂模式测试
 *
 */
public class TestFactory {
    public static void main(String[] args){
        //简单工厂模式测试
        ProductFactory productFactory = new ProductFactory();
        Product boat = productFactory.create("boat");
        Product car = productFactory.create("car");
        Product plane = productFactory.create("plane");

        //工厂方法模式测试
        BoatFactory boatFactory = new BoatFactory();
        Boat boat1 = boatFactory.create();

        CarFactory carFactory = new CarFactory();
        Car car1 = carFactory.create();

        PlaneFactory planeFactory = new PlaneFactory();
        Plane plane1 = planeFactory.create();

        //抽象工厂模式测试
        BoatFactory1 boatFactory1 = new BoatFactory1();
        boatFactory1.createMateril();
        boatFactory1.createProduct();

        CarFactory1 carFactory1 = new CarFactory1();
        carFactory1.createMateril();
        carFactory1.createProduct();

        PlaneFactory1 planeFactory1 = new PlaneFactory1();
        planeFactory1.createMateril();
        planeFactory1.createProduct();

        /**
         * 无论是简单工厂模式，工厂方法模式，还是抽象工厂模式，他们都属于工厂模式，在形式和特点上也是极为相似的，
         * 他们的最终目的都是为了解耦。在使用时，我们不必去在意这个模式到底工厂方法模式还是抽象工厂模式，因为他们
         * 之间的演变常常是令人琢磨不透的。经常你会发现，明明使用的工厂方法模式，当新需求来临，稍加修改，加入了一
         * 个新方法后，由于类中的产品构成了不同等级结构中的产品族，它就变成抽象工厂模式了；而对于抽象工厂模式，当
         * 减少一个方法使的提供的产品不再构成产品族之后，它就演变成了工厂方法模式。
         * 所以，在使用工厂模式时，只需要关心降低耦合度的目的是否达到了。
         */

    }
}
