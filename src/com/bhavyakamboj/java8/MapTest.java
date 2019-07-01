package com.bhavyakamboj.java8;

import com.bhavyakamboj.java8.ComparatorTest;

import java.util.HashMap;
import java.util.stream.Collectors;

public class MapTest {
    class StarEmployee{
        private String name;
        private String grade;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "StarEmployee{" +
                    "name='" + name + '\'' +
                    ", grade='" + grade + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        ComparatorTest.generateEmployees().stream()
                .map(Employee::getName)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);


        ComparatorTest.generateEmployees().stream()
                .map(employee -> employee.getName() + " " + employee.getAge() + " " + employee.getSalary())
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        MapTest mapTest = new MapTest();
        mapTest.starEmployees();
    }
    public void starEmployees(){
        ComparatorTest.generateEmployees().stream()
                .map(employee -> {
                    StarEmployee starEmployee = new StarEmployee();
                    starEmployee.setName(employee.getName());
                    starEmployee.setGrade((employee.getAge()<25?"A":employee.getAge()<45?"B":"C"));
                    return starEmployee;
                })
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
