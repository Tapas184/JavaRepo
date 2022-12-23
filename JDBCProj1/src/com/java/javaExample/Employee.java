package com.java.javaExample;

public class Employee {

	String name;
	int id;
	String eadd;
	float salary;
	
	Employee(String name,int id,String eadd,float salary)
	{
		this.name = name;
		this.id = id;
		this.eadd = eadd;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEadd() {
		return eadd;
	}

	public void setEadd(String eadd) {
		this.eadd = eadd;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", eadd=" + eadd + ", salary=" + salary + "]";
	}

   
	


}
