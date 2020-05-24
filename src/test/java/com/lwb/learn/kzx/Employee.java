package com.lwb.learn.kzx;

/**
 * Employee实体
 *
 * @Author: liwenbin
 * @Date: 2019/05/08
 */
public class Employee implements Comparable<Employee> {
    private String name;
    private Integer age;
    private Double salary;

    public Employee(String name, Integer age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "{name='" + name + ", age=" + age + ", salary=" + salary + '}';
    }

    @Override
    public int compareTo(Employee e) {
        int res1 = this.salary.compareTo(e.salary);
        if (res1 != 0) return -res1;
        int res2 = this.age.compareTo(e.age);
        if (res2 != 0) return res2;
        int res3 = this.name.compareToIgnoreCase(this.name);
        return res3;
    }
}
