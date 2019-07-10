package com.bhavyakamboj.enums;

public class EnumExample2 {
	enum Season2{
		WINTER2(5), SPRING2(10), SUMMER2(15), FALL2(20);
		private int value;
		private Season2(int value) {
			this.value = value;
		}
	} 
	
	public static void main(String[] args) {
		for(Season2 s: Season2.values())
			System.out.println(s + " " + s.value);
	}

}
