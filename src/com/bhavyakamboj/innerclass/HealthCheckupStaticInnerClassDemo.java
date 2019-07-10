package com.bhavyakamboj.innerclass;

public class HealthCheckupStaticInnerClassDemo{
	public static void main(String[] args) {
		Employee3 emp = new Employee3(126000, "Bhavya",HealthEnum.BAD);
		Employee3.HealthResult healthResult = emp.checkhealth();
		System.out.println(healthResult);
	}

}
abstract class Person3{
	private int id;
	private String name;
	private HealthEnum healthStatus;

	public Person3(int id, String name, HealthEnum status) {
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
class Employee3 extends Person3{

	public Employee3(int id, String name, HealthEnum status) {
		super(id, name, status);
	}

	public static class HealthResult{
		private HealthEnum result;
		private int checkupCount;
		public HealthEnum getResult() {
			return result;
		}
		public int getCheckupCount(int checkupCount) {
			return checkupCount;
		}
		public void setCheckupCount(int checkupCount) {
			this.checkupCount = checkupCount;
		}
		public void setResult(HealthEnum result) {
			this.result = result;
		}
		public String toString() {
			return "Checkup count: " + checkupCount + ", HealthResult: " + result; 
		}
	}
	
	public HealthResult checkhealth() {
		final HealthResult healthResult = new HealthResult();
		super.checkHealth(new HealthCheckup() {

			@Override
			public void checkup() {
				for(int i=0; i<5; i++)
					System.out.println("Checking health of "+ getName());
				healthResult.setCheckupCount(5);
				healthResult.setResult(HealthEnum.GOOD);
			}
		});
		return healthResult;
	}
	
}