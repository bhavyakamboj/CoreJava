package com.bhavyakamboj.java8;

public class Employee {
    public Employee(int age, String name, int salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

    private int age;
    private String name;
    private int salary;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
