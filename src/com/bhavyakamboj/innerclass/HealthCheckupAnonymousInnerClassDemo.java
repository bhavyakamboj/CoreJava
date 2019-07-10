package com.bhavyakamboj.innerclass;

public class HealthCheckupAnonymousInnerClassDemo {

	public static void main(String[] args) {
		Employee2 emp2 = new Employee2(126000, "Bhavya", HealthEnum.BAD);
		emp2.checkHealth();
	}

}
abstract class Person2{
	private int id;
	private String name;
	private HealthEnum healthStatus;

	public Person2(int id, String name, HealthEnum status) {
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
class Employee2 extends Person2{
	public Employee2(int id, String name, HealthEnum status) {
		super(id,name,status);
	}
	
	public void checkHealth() {
		
		super.checkHealth(new HealthCheckup() {
			@Override
			public void checkup() {
				for(int i=0; i<5; i++)
					System.out.println("Checking health of " + getName());
				}
			});
	}
}