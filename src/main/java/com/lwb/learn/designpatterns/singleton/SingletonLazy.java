package com.lwb.learn.designpatterns.singleton;

/**
 * 单例模式的懒汉式[线程不安全，不可用]
 */
public class SingletonLazy {
    private static SingletonLazy singletonLazy = null;

    private SingletonLazy() {
    }

    public static SingletonLazy getInstance() {
        if (null == singletonLazy) {
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }

}
