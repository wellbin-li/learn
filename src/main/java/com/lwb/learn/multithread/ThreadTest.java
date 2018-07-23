package com.lwb.learn.multithread;

/**
 * https://www.cnblogs.com/snow-flower/p/6114765.html
 * https://www.cnblogs.com/yjd_hycf_space/p/7526608.html
 *
 * Thread和Runnable的区别
 * 如果一个类继承Thread，则不适合资源共享。但是如果实现了Runable接口的话，则很容易的实现资源共享。
 * 总结：
 * 实现Runnable接口比继承Thread类所具有的优势：
 * 1）：适合多个相同的程序代码的线程去处理同一个资源
 * 2）：可以避免java中的单继承的限制
 * 3）：增加程序的健壮性，代码可以被多个线程共享，代码和数据独立
 * 4）：线程池只能放入实现Runable或callable类线程，不能直接放入继承Thread的类
 */
public class ThreadTest {

    public static void main(String[] args){
        // 方式1 继承Thread类
        Thread1 th1 = new Thread1("A");
        Thread1 th2 = new Thread1("B");
        th1.start();
        th2.start();

        // 方式2 实现runable接口
        new Thread(new Thread2("C")).start();
        new Thread(new Thread2("D")).start();


    }
}
