package hello;

import java.util.Arrays;
import java.util.List;

public class LambdaExample {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		numbers.forEach(System.out::println);

		numbers.forEach(i -> System.out.println("Here" + i));

		MyLambda greetingFunction = () -> System.out.println("HelloWorld");
		greetingFunction.foo();

		Greeting greetingFunctionTest = () -> System.out.println("HelloWorld Test");
		greetingFunctionTest.perform();

		Add addElements = (int a, int b) -> a + b;

		MyComparator compartor = (a1, a2) -> a1 > a2;
		System.out.println(compartor.compare(2, 1));

	}
}

interface Add {
	int add(int a, int b);
}

interface MyLambda {
	void foo();
}

interface Greeting {
	void perform();
}

class HelloWorldGreeting implements Greeting {

	@Override
	public void perform() {
		//System.out.println("HelloWorld");
	}

}

interface MyComparator {

	public boolean compare(int a1, int a2);

}