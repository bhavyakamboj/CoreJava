package com.bhavyakamboj.java8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class ForEachTest {
    public static void main(String[] args) {
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        items.forEach((k,v) -> System.out.println(k + " " + v));

        Map<Integer, Integer> ints = new HashMap<>();
        ThreadLocalRandom.current().ints(10, 1,10).filter(x->x>5).forEach(System.out::println);
        
    }
}
