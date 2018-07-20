package com.lwb.learn.designpatterns.singleton;

public class TestHungry extends Thread {
    public static void main(String[] args) {
        TestHungry t1 = new TestHungry();
        TestHungry t2 = new TestHungry();
        TestHungry t3 = new TestHungry();
        t1.start();
        t2.start();
        t3.start();
    }

    @Override
    public void run() {
        System.out.println(SingletonHungry.getInstance());
    }
}
