package hello;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		int i = 0;
		while (i <= 10) {
			i = i + 1;
		}

		long t1 = System.currentTimeMillis();
		// long t2 = System.currentTimeMillis();
		System.out.println("t1-t2" + (t1 < 0));
		List<Developer> listDevs = getDevelopers();

		System.out.println("Before Sort");
		for (Developer developer : listDevs) {
			System.out.println("Name :"+developer.name+" :Age: "+developer.age +" :Salary:"+developer.salary);
		}

		System.out.println("After Sort");

		// lambda here!
		listDevs.sort((Developer o1, Developer o2) -> o1.getAge() - o2.getAge());

		// java 8 only, lambda also, to print the List
		listDevs.forEach((developer) -> System.out.println("Name :"+developer.name+" :Age: "+developer.age +" :Salary:"+developer.salary));
	
		listDevs.sort((o1, o2)->o1.getSalary().compareTo((o2.getSalary())));
	
		listDevs.forEach((developer) -> System.out.println("Name :"+developer.name+" :Age: "+developer.age +" :Salary:"+developer.salary));
		
	}

	private static List<Developer> getDevelopers() {

		List<Developer> result = new ArrayList<Developer>();

		result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
		result.add(new Developer("alvin", new BigDecimal("80000"), 20));
		result.add(new Developer("jason", new BigDecimal("100000"), 10));
		result.add(new Developer("iris", new BigDecimal("170000"), 55));

		return result;

	}

}
