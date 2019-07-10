package com.bhavyakamboj.exception;

public class BakeOven {
	public static boolean isOvenOn = false;
	
	public static void bake() {
		int i=0;
			try {
				Thread.sleep(3000);
				i++;
				i++;
				i++;
				if(i>=3)
					throw new RuntimeException("Time's up!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				isOvenOn = false;
				System.out.println("Turned off oven from finally");
			}
	}
	
	public static void turnOnOven() {
		isOvenOn = true;
		System.out.println("Turned on oven");
	}
	
	
	public static void main(String[] args) {
		BakeOven.turnOnOven();
		BakeOven.bake();
	}
	
}
