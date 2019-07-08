package serialization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class Employee2 implements Externalizable{
	private String name;
	private int age;
	private String sex;
	private static final long serialVersionUID = 2616423033716253195L;
	
	public Employee2() {
		this.name = "";
		this.age = 0;
		this.sex = "";
	}
	public Employee2(String name, int age, String sex) {
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
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeUTF(name);
		out.writeInt(age);
		out.writeUTF(sex);		
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.name = in.readUTF();
		this.age = in.readInt();
		this.sex = in.readUTF();	
	}
}
public class EmployeeExternalizationTest {

	public static void main(String[] args) {
		Employee2 theEmployee = new Employee2("Bhavya", 26, "Male");
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.txt"));
			theEmployee.writeExternal(oos);
			
			oos.flush();
			oos.close();
			
			ObjectInputStream ois =  new ObjectInputStream(new FileInputStream("employee.txt"));
			
			Employee2 recoveredEmployee = new Employee2();
			recoveredEmployee.readExternal(ois);
			
			ois.close();

			System.out.println(recoveredEmployee.getName());
			System.out.println(recoveredEmployee.getAge());
			System.out.println(recoveredEmployee.getSex());
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
