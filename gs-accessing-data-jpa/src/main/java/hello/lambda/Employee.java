package hello.lambda;

public class Employee {
	
	public String name;
	public int age;
	public Email emailId;

	
	public Employee(String name, int age, Email emailId) {
		
		this.name = name;
		this.age = age;
		this.emailId = emailId;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the emailId
	 */
	public Email getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(Email emailId) {
		this.emailId = emailId;
	}

}
