package com.bhavyakamboj.java8;

import java.math.BigDecimal;
import java.security.cert.CollectionCertStoreParameters;
import java.util.*;
import java.lang.System;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GroupByTest {
    public static void main(String[] args) {
        Stream.of(0,1,2,3,4,5,6,7,8,9,1,2,5,2,2,4,0,6,2,7,8,9,3,0,7,5,4,6,8,9)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .forEach((x,v)-> System.out.println("Number: " +x + ", count: " + v));


//        ThreadLocalRandom.current().ints(20, 0, 9)
//                .boxed()
//                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
//                .forEach((x,v)-> System.out.println("Number: " +x + ", count: " + v));


        System.out.println("Printing stream of Integers");

        Map<Integer, Long> result = ThreadLocalRandom.current().ints(1000, 0, 10)
                .boxed()
                .sorted()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())); //.counting()

        Map<Integer, Long> finalMap = new LinkedHashMap<>();

        result.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue()
                        .reversed())
                .forEachOrdered(e->finalMap.put(e.getKey(), e.getValue()));

        System.out.println(finalMap);

        // group by a list of user objects
        System.out.println("group by a list of user objects");
        List<Employee> employees = ComparatorTest.generateEmployees();

        Map<String, Long> counting = employees.stream().collect(
                Collectors.groupingBy(Employee::getName,Collectors.counting()));

        System.out.println(counting);

        Map<String, Long> sum = employees.stream().collect(
                Collectors.groupingBy(Employee::getName,Collectors.summingLong(Employee::getSalary)));

        System.out.println(sum);

        // group by salary, uses 'mapping' to convert List<Employee> to Set<String>
        Map<Integer, Set<String>> result2 =
                employees.stream().collect(
                        Collectors.groupingBy(Employee::getSalary,
                                Collectors.mapping(Employee::getName, Collectors.toSet())
                        )
                );

        System.out.println(result2);

        // group by age, uses 'mapping' to convert List<Employee> to Set<String>

        Map<Integer, Set<String>> result3 =
                employees.stream().collect(
                        Collectors.groupingBy(Employee::getAge,
                                Collectors.mapping(Employee::getName, Collectors.toSet())
                        )
                );

        System.out.println(result3);
    }
}