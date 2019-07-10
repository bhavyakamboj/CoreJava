package com.bhavyakamboj.innerclass;

public class SimpleInnerClassDemo {
	private int id;
	private String name;
	
	public SimpleInnerClassDemo(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public class Inner{
		public String getName() {
			return SimpleInnerClassDemo.this.name;
		}
	}
	
	public static void main(String[] args) {
		SimpleInnerClassDemo demo = new SimpleInnerClassDemo(126000,"Bhavya");
		SimpleInnerClassDemo.Inner inner = demo.new Inner();
		System.out.println(inner.getName());
	}

}
