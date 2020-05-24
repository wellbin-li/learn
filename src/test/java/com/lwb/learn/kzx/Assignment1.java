package com.lwb.learn.kzx;

/**
 * 任务1：按薪水高低对员工信息排序并打印
 *
 * @Author: liwenbin
 * @Date: 2019/05/08
 */
public class Assignment1 {

    public static void main(String[] args) {

//        //第一种方式：利用TreeMap并在Employee类中实现Comparable接口
//        long start = System.currentTimeMillis(); //计时开始
//        TreeSet<Employee> treeSet = new TreeSet<>();
//        for (int i = 0; i < 1000; i++) {  //构造Employee，并添加至treeSet
//            treeSet.add(new Employee(Utils.constructName(), Utils.constructAge(), Utils.constructSalary()));
//        }
//        System.out.println("耗时：" + (System.currentTimeMillis() - start)); //打印构造和排序过程耗时，约100毫秒
//
//        Iterator<Employee> iterator = treeSet.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next().toString());
//        }


        //第二种方式：创建Employee数组，利用手写的堆排序
        Employee[] employees = new Employee[1000]; //构造Employee数组
        for (int i = 0; i < 1000; i++) {  //对Employee数组中每个元素进行name、age、salary赋值
            employees[i] = new Employee(Utils.constructName(), Utils.constructAge(), Utils.constructSalary());
        }

        long start = System.currentTimeMillis();   //计时开始
        Utils.heapSortForEmployeeArray(employees);  //对Employee数组按salary进行堆排序
        System.out.println("耗时：" + (System.currentTimeMillis() - start));  //打印排序过程耗时，约4~5毫秒

        for (int i = 0; i < 1000; i++) { //打印Employee数组
            System.out.println(employees[i].toString());
        }
    }
}
