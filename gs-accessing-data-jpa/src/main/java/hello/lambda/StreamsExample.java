package hello.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamsExample {

	public static void main(String[] args) {

		// variadic method example
		Stream<Integer> fib = Stream.of(1, 1, 2, 3);
		Stream<String> italianNumbers = Stream.of("uno", "duo", "three");
		System.out.println(fib.findFirst() + " <-- -->" + italianNumbers.findFirst());

		Random random = new Random();

		Stream<Integer> randoms = Stream.generate(random::nextInt);

		System.out.println(randoms.isParallel());
		
		lazyTests();
		streamTravese();
		intermediateStreams();
		terminalStreams();
	}

	public static void lazyTests() {

		Random random = new Random();
		
		Supplier<Integer> supplier = () -> {
			Integer result = random.nextInt();
			System.out.println("Suppliying result " + result);
			return result;
		};
		
		System.out.println(" In test 1");
		Stream<Integer> randoms = Stream.generate(supplier);
		System.out.println(" First streams built in");
		
		randoms.filter(n -> n>=0).limit(3).forEach(System.out::println);
	
	}
	
	public static void streamTravese() {
		Stream<Integer> fib = Stream.of(1, 1, 2, 3);
		fib.limit(2);
		//fib.forEach(System.out::println);
		//fib.forEach(System.out::println);
		
		
	}
	
	public static void intermediateStreams() {
		System.out.println("In Intermediate Streams");
		Stream <Employee> emps = Arrays.asList(getEmployees()).stream();
		
		emps.sorted(Comparator.comparingInt(Employee::getAge).reversed())
			.limit(10).map(Employee::getName)
			.forEachOrdered(System.out::println);
		System.out.println("End of Intermediate Streams");
	}
	
	public static void terminalStreams() {
		System.out.println("In Terminal Streams");
		Stream<Employee> emps =  Arrays.asList(getEmployees()).stream();
		boolean isValid = emps.allMatch(e -> e.getName() != null && 
				e.getName().length() >0);
		System.out.println("terminalStreams -->"+isValid);
		
		System.out.println("End of Terminal Streams");
	}
	
	public static Employee[] getEmployees() {
		
		Employee[] emp = new Employee[5];
		
		emp[0] = new Employee("Alec", 40, new Email("alec@epam.com"));
		emp[1] = new Employee("Bob", 39, new Email("bob@epam.com"));
		emp[2] = new Employee("Clarie", 22, new Email("clarie@epam.com"));
		emp[3] = new Employee("Stewart", 50, new Email("stewart@epam.com"));
		emp[4] = new Employee("Srinivas", 43, new Email("srinivas@epam.com"));
		
		return emp;
	}
}
