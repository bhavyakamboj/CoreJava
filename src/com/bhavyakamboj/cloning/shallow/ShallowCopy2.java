package com.bhavyakamboj.cloning.shallow;
class Company{
		int id;
		String name;
		public Company(int id, String name){
			this.id = id;
			this.name = name;
		}
	}
class Employee implements Cloneable{
		int eid;
		String name;
		Company company;
		public Employee(int eid, String name, Company company){
			this.eid = eid;
			this.name = name;
			this.company = company;
		}
		
		protected Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
	}

public class ShallowCopy2 {

	public static void main(String[] args) throws CloneNotSupportedException{
		// TODO Auto-generated method stub
		Company c1 = new Company(1,"Sapient");
		Employee e1 = new Employee(1,"Bhavya",c1);
		System.out.println(e1.eid + " " + e1.name + " Company: " + e1.company.name);
		Employee e2 = (Employee)e1.clone();
		System.out.println(e2.eid + " " + e2.name + " Company: " + e2.company.name);
		e2.company.name = "Expedia";
		System.out.println(e1.eid + " " + e1.name + " Company: " + e1.company.name);
		System.out.println(e2.eid + " " + e2.name + " Company: " + e2.company.name);
	}

}
