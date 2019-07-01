package com.bhavyakamboj.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    public static List<Employee> generateEmployees(){
        return new ArrayList<>(){
            {
                add(new Employee(11,"Chirag",4242552));
                add(new Employee(43,"Abhinav",4592572));
                add(new Employee(11,"Bhavya",3252352));
                add(new Employee(23,"Chirag",4242552));
                add(new Employee(23,"Abhinav",4592572));
                add(new Employee(43,"Bhavya",3252352));
            }
        };
    }

    public static void printEmployees(List<Employee> employees){
        employees.forEach(e-> System.out.println(e));
    }

    public static void main(String[] args) {
        List<Employee> employees = generateEmployees();

        Comparator<Employee> byName = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Comparator<Employee> byAge = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getAge()-o2.getAge();
            }
        };

        Comparator<Employee> bySalary = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getSalary()-o2.getSalary();
            }
        };

        Comparator<Employee> byNameLambda = (o1,o2) -> o1.getName().compareTo(o2.getName());

        System.out.println("By name lambda");

        employees.sort(((o1, o2) -> o1.getName().compareTo(o2.getName())));

        printEmployees(employees);

        System.out.println("By age lambda");

        employees.sort(((o1, o2) -> o1.getAge() - o2.getAge()));

        printEmployees(employees);


        System.out.println("By salary lambda");

        employees.sort(((o1, o2) -> o1.getSalary() - o2.getSalary()));

        printEmployees(employees);



    }
}

