package hello;

import java.math.BigDecimal;

public class Developer {
	
	public String name;
	public BigDecimal salary;
	public int age;
	
	public Developer(String name, BigDecimal salary, int age) {
		this.age = age;
		this.salary = salary;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


}
