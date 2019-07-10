package com.bhavyakamboj;


public class HelloWorld {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		System.out.println(String.class.getClassLoader());
		System.out.println(HelloWorld.class.getClassLoader());
		Object obj = Class.forName("java.lang.Object").newInstance();
		System.out.println(obj.getClass());		
	}
	static class Greet {
		private String message;
		Greet(String message){
			this.message = message;
		}
		void printMessage() {
			System.out.println(this.message);
		}
	}
}
