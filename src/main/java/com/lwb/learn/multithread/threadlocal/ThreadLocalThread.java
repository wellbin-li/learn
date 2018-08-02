package com.lwb.learn.multithread.threadlocal;

import java.util.Random;

public class ThreadLocalThread implements Runnable {

    private final static ThreadLocal studentLocal = new ThreadLocal();

    @Override
    public void run() {
        accessStudent();
    }

    public void accessStudent() {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println(currentThreadName + "is running");

        Random random = new Random();
        int age = random.nextInt(100);
        System.out.println(currentThreadName + "set age to " + age);

        Student student = getStudent();
        student.setAge(age);
        System.out.println(currentThreadName + "first read age is" + student.getAge());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(currentThreadName + "second read age is" + student.getAge());
    }

    private Student getStudent() {
        Student student = (Student) studentLocal.get();
        if (student == null) {
            student = new Student();
            studentLocal.set(student);
        }
        return student;
    }
}
