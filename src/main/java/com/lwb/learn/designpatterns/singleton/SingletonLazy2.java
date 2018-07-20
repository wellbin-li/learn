package com.lwb.learn.designpatterns.singleton;

/**
 * 单例模式懒汉式[线程不安全，不可用]
 * <p>
 * 虽然加了锁，但是等到第一个线程执行完instance=new Singleton()跳出这个锁时，
 * 另一个进入if语句的线程同样会实例化另外一个Singleton对象，线程不安全的原理跟3类似。
 */
public class SingletonLazy2 {
    private static SingletonLazy2 singletonLazy2 = null;

    private SingletonLazy2(){
    }

    public static SingletonLazy2 getInstance(){
        if(null == singletonLazy2) {
            synchronized (SingletonLazy2.class) {
                singletonLazy2 = new SingletonLazy2();
            }
        }
        return singletonLazy2;
    }
}
