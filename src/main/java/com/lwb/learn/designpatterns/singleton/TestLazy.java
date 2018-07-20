package com.lwb.learn.designpatterns.singleton;

public class TestLazy extends Thread {
    public static void main(String[] args){
        TestLazy t1 = new TestLazy();
        TestLazy t2 = new TestLazy();
        TestLazy t3 = new TestLazy();
        t1.start();
        t2.start();
        t3.start();
    }

    @Override
    public void run() {
        System.out.println(SingletonLazy3.getInstance());
    }
}
