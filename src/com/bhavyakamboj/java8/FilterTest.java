package com.bhavyakamboj.java8;

import com.bhavyakamboj.java8.ComparatorTest;
import com.bhavyakamboj.java8.Employee;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterTest {

    public static void main(String[] args) {
        List<String> words = List.of("Bhavya","Kamboj","is","an","idiot");
        words.stream()
                .filter(word -> !"fucking".equals(word))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("New stream ");

        words.stream()
                .filter((p) -> !"Bhavya".equals(p) && !"fucking".equals(p))
//                .forEach(System.out::println);
                .findAny()
                .orElse(null);

        List<Employee> employees = ComparatorTest.generateEmployees();
        employees.stream()
                .filter((e)->e.getAge()>25)
                .map(Employee::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);


        // filter null value from stream
        Stream<String> names = Stream.of("A","B",null,"D",null,"E");

        List<String> result = names.filter(Objects::nonNull).collect(Collectors.toList()); //x->x!=null

        result.forEach(System.out::println);
    }
}
