package hello.lambda;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaImplementation {
	
	
	public static void main(String s[]) {
		
		
		Consumer<String> myPrinter = new Consumer<String>() {

			@Override
			public void accept(String msg) {
				System.out.println("Consuming -->" + msg);
			}
		};  
		myPrinter.accept(myPrinter.toString());
		
		
		System.out.println(" Non Capturing Lambda");
		Consumer<String> myPrinter2 = msg -> System.out.println(" Lambda 1 -->"+msg);
		
		myPrinter2.accept(myPrinter2.toString());
		
		final int secret = 27;
		
		System.out.println(" Capturing final in Lambda");
		Consumer<String> myPrinter3 = msg1 -> System.out.println(" Lambda 2 -->"+secret+"<-- msg -->"+msg1);
		
		myPrinter3.accept(myPrinter3.toString());
		
		
		
		Employee frank = new Employee("Frank", 41, new Email("naga_@epam.com"));
		System.out.println("frank -->"+frank.getEmailId().getEmailId());
		
		Integer age = frank.getAge();
		System.out.println("age -->"+age);
		
		Supplier<Email> s2 = frank::getEmailId;
		
		System.out.println(" Email is from Supplier"+s2.get().getEmailId());
		
		Function<Employee, Integer> f1 = Employee::getAge;
		
		Integer frankAge = f1.apply(frank);
		
		System.out.println("frankAge -->"+frankAge);
		
		System.out.println();
		
		Employee[] dept = new Employee[5];
		
		dept[0] = new Employee("Alec", 40, new Email("alec@epam.com"));
		dept[1] = new Employee("Bob", 39, new Email("bob@epam.com"));
		dept[2] = new Employee("Clarie", 22, new Email("clarie@epam.com"));
		dept[3] = new Employee("Stewart", 50, new Email("stewart@epam.com"));
		dept[4] = new Employee("Srinivas", 43, new Email("srinivas@epam.com"));
		
		
		
		//printAll(T[] array, Function<T, String> toString);
		printAll(dept, Employee::getName);
		
		System.out.println(composeHashCodes("Hello", "World"));
		System.out.println(composeHashCodes("Hello", "null"));
	
		try {
			System.out.println(composeHashCodes2("Hello", null));
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			
		}
		
		try {
			System.out.println(composeHashCodes3("Hello", null));
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
		final Random random = new Random();
		
		BooleanSupplier randomBS = random::nextBoolean;
		
		System.out.println(" randomBS -->"+randomBS.getAsBoolean());
		
		try {
			PrintWriter writer = new PrintWriter("fileout.txt");
			
			Consumer<String> logger = writer::println;
			
			Consumer<String> screen = System.out::println;
			
			Consumer<String> both = logger.andThen(screen);
			
			both.accept("Program Started");
			writer.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		
		Arrays.stream(dept)
				.filter(e -> e.getAge() <=40)
				.map(Employee::getName).sorted().forEach(System.out::println);
		
	}

	private static int composeHashCodes(String a, String b) {
		
		return a.hashCode()^b.hashCode();
	}

	
	private static int composeHashCodes2(String a, String b) {
		
		Objects.requireNonNull(a, " composeHashCodes2 a may not be null"+ getApplicationStatus());
		Objects.requireNonNull(b, " composeHashCodes2 b may not be null"+ getApplicationStatus());
		
		return a.hashCode()^b.hashCode();
	}
	
	
	private static int composeHashCodes3(String a, String b) {
		
		Objects.requireNonNull(a, () -> " composeHashCodes3 a may not be null"+ getApplicationStatus());
		Objects.requireNonNull(b, () -> " composeHashCodes3 b may not be null"+ getApplicationStatus());
		
		return a.hashCode()^b.hashCode();
	}
	private static String getApplicationStatus() {
		System.out.println(" It is a application status");
		return "It's"+ LocalTime.now();
	}

	private static <T> void printAll(T[] dept, Function<T, String> toString) {
		int i = 0;
		for (T t : dept) {
			System.out.println(i++ +"\t"+toString.apply(t));
		}
	}
	
	

}
