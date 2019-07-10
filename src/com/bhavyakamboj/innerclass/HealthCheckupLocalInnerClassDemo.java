package com.bhavyakamboj.innerclass;

public class HealthCheckupLocalInnerClassDemo {

	
	public static void main(String[] args) {
		Employee1 emp1 = new Employee1(126000, "Bhavya", HealthEnum.BAD);
		emp1.checkHealth();
	}
}
abstract class Person1{
	private int id;
	private String name;
	private HealthEnum healthStatus;

	public Person1(int id, String name, HealthEnum status) {
		this.id = id;
		this.name = name;
		this.healthStatus = status;
	}
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	
	public void checkHealth(HealthCheckup checkup) {
		if(healthStatus == HealthEnum.BAD) {
			checkup.checkup();
		} else {
			System.out.println("Good luck!"+name);
		}
	}
}
class Employee1 extends Person1{
	public Employee1(int id, String name, HealthEnum status) {
		super(id,name,status);
	}
	
	void checkHealth() {
		class HealthMonitor implements HealthCheckup {
			@Override
			public void checkup() {
				for(int i=0; i<5; i++)
					System.out.println("Checking health of " + getName());
				}
			}
		HealthCheckup checkup = new HealthMonitor();
		super.checkHealth(checkup);
	}
}
