package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Decoration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Decorable dec = (int num) -> {System.out.println("Using paint # "+num);};
		Decorable.printHello();
		dec.decorateWithCurtains();
		dec.decorateWithPaint(10);
		
		//Old way of thread 
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread 1 is running");
			}
		});
		t1.start();
		//Thread using functional interface
		new Thread(()->{System.out.println("Thread 2 is running");}).start();
		
		//comparator example
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(3,"Bhavya"));
		students.add(new Student(2,"Bob"));
		students.add(new Student(4,"Mark"));
		students.add(new Student(7,"Bhavna"));
		students.add(new Student(1,"Anjali"));
		
//		Collections.sort(students,(o1,o2)->o1.getId()-o2.getId());
		Collections.sort(students, (s1,s2)->s1.getName().compareTo(s2.getName()));
		for(Student s:students)
			System.out.println(s);
		List<Student> bs = students.stream().filter(s->s.getName().startsWith("A")).collect(Collectors.toList());
		System.out.println("Printing only B's");
		for(Student s:bs)
			System.out.println(s);	
		
		//Predicates
		Predicate<Integer>  predicate = i->i>100;
		boolean greaterThanCheck = predicate.test(200);
		System.out.println(greaterThanCheck);
	
	}

}
class Student{
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	private int id;
	private String name;
	
	//Method overloading
	public String returnSomething() {
		return "Something";
	}
}