package com.lwb.learn.multithread;

/**
 * 多线程经典案例 多线程多消费(synchronized)
 */
public class ThreadTest3 {
    public static void main(String[] args) {
        resource r=new resource();//为不同的方法设置同一个资源
        producer p1= new producer(r);
        consumer c1=new consumer(r);
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



//将共有资源封装
class resource {
    private String name;
    private int count = 1;
    private boolean flag = false;

    public synchronized void set(String name) { //同步set方法
        if (flag) { //如果为假，生产烤鸭，如果为真，等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name + count;
        count++;
        System.out.println(Thread.currentThread().getName() + ".生产者..." + this.name);
        flag = true;
        notifyAll(); //防止死锁问题，唤醒线程池中的全部线程
    }

    public synchronized void out() { //同步out方法
        if (!flag) { //如果为真，消费烤鸭，如果为假，等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ".....消费者" + this.name);
        flag = false;
        notifyAll();//防止死锁问题，唤醒线程池中全部线程
    }
}

class producer implements Runnable{
    private resource r;
    public producer( resource r){
        this.r=r;
    }

    @Override
    public void run() {
        while (true)
        {
            r.set("烤鸭");
        }
    }
}

class consumer implements Runnable{
    private resource r;
    public consumer( resource r){
        this.r=r;
    }

    @Override
    public void run() {
        while (true)
        {
            r.out();
        }
    }
}