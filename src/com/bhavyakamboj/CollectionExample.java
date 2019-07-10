package com.bhavyakamboj;

import java.util.*;

public class CollectionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractCollection<Object> abs = new ArrayList<Object>();
		abs.add("Hello");
		System.out.println(abs);
		// creating a collection
		List<String> strings = new ArrayList<String>();
		strings.add("one");
		strings.add("two");
		System.out.println(strings);
		// adding collection using addAll()
		abs.addAll(strings);
		System.out.println(abs);
		// removing elements
		strings.clear();
		strings.addAll(Arrays.asList("a","b"));
		System.out.println(strings);
		
		Set<Integer> set = new HashSet<>();
		Boolean status = set.add(1);
		System.out.println(status);
		status = set.add(1);
		System.out.println(status=set.addAll(Arrays.asList(2,1)));
		
		
	}

}
