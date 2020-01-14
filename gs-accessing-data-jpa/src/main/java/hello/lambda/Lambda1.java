package hello.lambda;

import java.util.Comparator;
import java.util.function.Consumer;

public class Lambda1 {
	
	
	public static void main(String s[]) {
		
		Comparator<Employee> byName = new Comparator<Employee>() {

			@Override
			public int compare(Employee a, Employee b) {
				
				return a.getName().compareTo(b.getName());
			}
			
		};
		
		System.out.println("Compare -->"+byName);
		
		Comparator<Employee> lambda1 = (Employee a, Employee b) -> { return a.getName().compareTo(b.getName());};
		
		System.out.println("lambda1 -->"+lambda1);
		
		Comparator<Employee> lambda2 = (a, b) -> {return a.getName().compareTo(b.getName());};
		System.out.println("lambda2 -->"+lambda2);
		
		Comparator<Employee> lambda3 = (a, b) -> a.getName().compareTo(b.getName());
		System.out.println("lambda3 -->"+lambda3);
		
		Comparator<Employee> lambda4 = (a, b) -> {return a.getName().compareTo(b.getName());};
		System.out.println("lambda4 -->"+lambda4);
		
		
		Runnable r = () -> { System.out.println(" Here in Lambda ");};
		Thread t1 = new Thread(r);
		t1.start();
		
		Thread t2 = new Thread(() -> System.out.println(" Implict Runnable Interface") ) ;
		t2.start();
		
		Consumer<String> lengthPrinter = s1 -> System.out.println(" s.length"+s1.length());
		
		
		String [] array = {"One", "Two", "Three"};
		
		String first = getFirst(array);
		System.out.println(" first -->"+first);
	}
	
	
	public static <T> T getFirst(T[] array) {
		
		
		return array[0];
	}

}
