package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable{
	private String name;
	private int age;
	private String sex;
	private int customData;
	private static final long serialVersionUID = 2616423033716253195L;
	public Employee(String name, int age, String sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}
	public String getSex() {
		return this.sex;
	}
	public int getCustomData() {
		return this.customData;
	}
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
		oos.writeInt(-1);
	}
	
	private void readObject(ObjectInputStream ois) 
			throws ClassNotFoundException, IOException{
		ois.defaultReadObject();
		customData = ois.readInt();
	}
}
public class EmployeeSerializationTest {

	public static void main(String[] args) {
		Employee theEmployee = new Employee("Bhavya", 26, "Male");
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.txt"));
			oos.writeObject(theEmployee);
			
			// Close all resources.
	        oos.flush();
	        oos.close();
	        
			ObjectInputStream ois =  new ObjectInputStream(new FileInputStream("employee.txt"));
			Employee recoveredEmployee = (Employee) ois.readObject();
			ois.close();
			
			System.out.println(recoveredEmployee.getName());
			System.out.println(recoveredEmployee.getCustomData());
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
