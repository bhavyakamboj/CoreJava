package innerclass;

public class HealthCheckupPrivateClassDemo {

	public static void main(String[] args) {
		Employee emp = new Employee(126000, "Bhavya Kamboj",HealthEnum.BAD);
		emp.checkHealth();
	}

}

enum HealthEnum{
	GOOD,BAD
}

interface HealthCheckup{
	void checkup();
}

abstract class Person{
	private int id;
	private String name;
	private HealthEnum healthStatus;

	public Person(int id, String name, HealthEnum status) {
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
class Employee extends Person{
	
	public Employee(int id, String name, HealthEnum status) {
		super(id,name,status);
	}
	
	private class HealthMonitor implements HealthCheckup{

		@Override
		public void checkup() {
			for(int i=0; i<5; i++) {
				System.out.println("Checking health of " + getName());
			}
		}	
	}
	
	public void checkHealth() {
		HealthCheckup checkup = new HealthMonitor();
		super.checkHealth(checkup);
	}
}