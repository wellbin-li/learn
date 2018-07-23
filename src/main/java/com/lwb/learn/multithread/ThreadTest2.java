package com.lwb.learn.multithread;

/**
 * 经典的面试题，题目要求如下：
 * 建立三个线程，A线程打印10次A，B线程打印10次B,C线程打印10次C，要求线程同时运行，交替打印10次ABC。这个问题用Object的wait()，notify()就可以很方便的解决。
 */
public class ThreadTest2 {
    public static void main(String[] args) throws Exception{
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        Thread3 ta = new Thread3("A",c,a);
        Thread3 tb = new Thread3("B",a,b);
        Thread3 tc = new Thread3("C",b,c);
        new Thread(ta).start();
        Thread.sleep(100);
        new Thread(tb).start();
        Thread.sleep(100);
        new Thread(tc).start();
        Thread.sleep(100);
    }
}
