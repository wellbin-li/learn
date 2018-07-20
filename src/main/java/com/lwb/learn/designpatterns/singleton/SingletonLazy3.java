package com.lwb.learn.designpatterns.singleton;

/**
 * 单例模式懒汉式双重校验锁[推荐用]
 * 懒汉式变种,属于懒汉式的最好写法,保证了:延迟加载和线程安全
 */
public class SingletonLazy3 {
    private static SingletonLazy3 singletonLazy3 = null;

    private SingletonLazy3(){
    }

    public static SingletonLazy3 getInstance(){
        if(null == singletonLazy3){
            synchronized (SingletonLazy3.class){
                if(null == singletonLazy3){
                    singletonLazy3 = new SingletonLazy3();
                }
            }
        }
        return singletonLazy3;
    }
}
