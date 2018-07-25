package com.lwb.learn.multithread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 多线程实现测试
 *
 * 参考：
 * https://www.cnblogs.com/snow-flower/p/6114765.html
 * https://www.cnblogs.com/yjd_hycf_space/p/7526608.html
 * https://www.cnblogs.com/lwbqqyumidi/p/3804883.html
 *
 * Thread和Runnable的区别
 * 如果一个类继承Thread，则不适合资源共享。但是如果实现了Runable接口的话，则很容易的实现资源共享。
 * 总结：
 * 实现Runnable接口比继承Thread类所具有的优势：
 * 1）：适合多个相同的程序代码的线程去处理同一个资源
 * 2）：可以避免java中的单继承的限制
 * 3）：增加程序的健壮性，代码可以被多个线程共享，代码和数据独立
 * 4）：线程池只能放入实现Runnable或callable类线程，不能直接放入继承Thread的类
 */
public class ThreadTest {

    public static void main(String[] args){
        // 方式1 继承Thread类
//        Thread1 th1 = new Thread1("A");
//        Thread1 th2 = new Thread1("B");
//        th1.start();
//        th2.start();

        // 方式2 实现runnable接口
//        new Thread(new Thread2("C")).start();
//        new Thread(new Thread2("D")).start();

        /**
         * 方式3 使用Callable和Future接口创建线程
         *
         * 使用Callable和Future接口创建线程。具体是创建Callable接口的实现类，并实现call()方法。
         * 并使用FutureTask类来包装Callable实现类的对象，且以此FutureTask对象作为Thread对象的target来创建线程。
         */
        Thread3 mycallable = new Thread3(); //创建Callable对象
        FutureTask ft = new FutureTask(mycallable);  //使用FutureTask来包装Callable对象

        for (int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName() + " " + i);
            if(i==30){
                Thread thread = new Thread(ft); //FutureTask对象作为Thread对象的target创建新的线程
                thread.start();
            }
        }

        System.out.println("主线程for循环执行完毕..");

        try {
            int sum = (Integer) ft.get(); //取得新创建的新线程中的call()方法返回的结果。 ft.get()方法获取子线程call()方法的返回值时，当子线程此方法还未执行完毕，ft.get()方法会一直阻塞，直到call()方法执行完毕才能取到返回值。
            System.out.println("sum = " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
