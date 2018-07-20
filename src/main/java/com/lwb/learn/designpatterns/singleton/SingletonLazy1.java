package com.lwb.learn.designpatterns.singleton;

/**
 * 懒汉式线程安全的:[线程安全，效率低不推荐使用]
 * <p>
 * 缺点：效率太低了，每个线程在想获得类的实例时候，执行getInstance()方法都要进行同步。
 * 而其实这个方法只执行一次实例化代码就够了，
 * 后面的想获得该类实例，直接return就行了。方法进行同步效率太低要改进。
 */
public class SingletonLazy1 {
    private static SingletonLazy1 singletonLazy1 = null;

    public SingletonLazy1() {
    }

    public static synchronized  SingletonLazy1 getInstance(){
        if(null == singletonLazy1){
            singletonLazy1 = new SingletonLazy1();
        }
        return singletonLazy1;
    }

}
