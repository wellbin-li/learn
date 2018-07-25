package com.lwb.learn.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock的使用:https://www.cnblogs.com/-new/p/7256297.html
 *
 * 多线程经典案例 多线程多消费(ReentrantLock)
 */
public class ThreadTest4 {
    public static void main(String[] args) {
        resource1 r=new resource1();//为不同的方法设置同一个资源
        producer1 p1= new producer1(r);
        consumer1 c1=new consumer1(r);
        //创造线程
        Thread t1=new Thread(p1);
        Thread t2=new Thread(p1);
        Thread t3=new Thread(c1);
        Thread t4=new Thread(c1);
        //开启线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}


class resource1 //将共有资源封装
{
    private String name;
    private int count=1;
    private boolean flag=false;
    Lock lock=new ReentrantLock();
    Condition con=lock.newCondition();
    Condition pro=lock.newCondition();

    public void set(String name)//同步set方法
    {
        lock.lock();
        try
        {

            while (flag)//如果为假，生产烤鸭，如果为真，等待
            {

                try{pro.await();}catch(InterruptedException e){}
            }
            this.name=name+count;
            count++;
            System.out.println(Thread.currentThread().getName()+".生产者..."+this.name);
            flag=true;
            con.signal();//防止死锁问题，唤醒线程池中的全部线程

        }
        finally
        {
            lock.unlock();
        }
    }
    public void out()//同步out方法
    {
        lock.lock();
        try
        {

            while(!flag)//如果为真，消费烤鸭，如果为假，等待
            {

                try{con.await();}catch(InterruptedException e){}
            }
            System.out.println(Thread.currentThread().getName()+".....消费者"+this.name);
            flag=false;
            pro.signal();//防止死锁问题，唤醒线程池中全部线程

        }
        finally
        {
            lock.unlock();
        }
    }

}

class producer1 implements Runnable
{
    private resource1 r;//不同的方法访问一个资源
    public producer1(resource1 r)
    {
        this.r=r;
    }
    public void run()
    {
        while (true)
        {
            r.set("烤鸭");
        }
    }
}
class consumer1 implements Runnable
{
    private resource1 r;
    public consumer1(resource1 r)
    {
        this.r=r;
    }
    public void run()
    {
        while (true)
        {
            r.out();
        }

    }
}
